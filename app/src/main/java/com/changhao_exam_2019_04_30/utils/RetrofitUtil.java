package com.changhao_exam_2019_04_30.utils;

import android.annotation.SuppressLint;

import com.changhao_exam_2019_04_30.apis.Api;
import com.changhao_exam_2019_04_30.callback.IOkHttpCallback;
import com.changhao_exam_2019_04_30.entity.HomeBean;
import com.changhao_exam_2019_04_30.service.IRetrofitService;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static RetrofitUtil instance;
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;


    private RetrofitUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(httpLoggingInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                if (instance == null) {
                    instance = new RetrofitUtil();
                }
            }
        }
        return instance;
    }

    @SuppressLint("CheckResult")
    public void doPost(String apiUrl, HashMap<String, Object> parmas, final IOkHttpCallback iOkHttpCallback) {
        IRetrofitService retrofitService = retrofit.create(IRetrofitService.class);

        retrofitService.doPost(apiUrl, parmas)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeBean>() {
                    @Override
                    public void accept(HomeBean homeBean) throws Exception {
                        if (iOkHttpCallback != null) {
                            iOkHttpCallback.onSuccess(homeBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (iOkHttpCallback != null) {
                            iOkHttpCallback.onFailed(throwable + "");
                        }
                    }
                });

    }
}
