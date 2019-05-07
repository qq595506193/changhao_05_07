package com.changhao_exam_2019_04_30.model;

import com.changhao_exam_2019_04_30.apis.Api;
import com.changhao_exam_2019_04_30.callback.IOkHttpCallback;
import com.changhao_exam_2019_04_30.callback.IRequestCallback;
import com.changhao_exam_2019_04_30.contract.HomeContract;
import com.changhao_exam_2019_04_30.utils.RetrofitUtil;

import java.util.HashMap;

public class HomeModel implements HomeContract.IHomeModel {
    @Override
    public void getHome(HashMap<String, Object> params, final IRequestCallback iRequestCallback) {
        RetrofitUtil.getInstance().doPost(Api.COLUMN_VIDEO, params, new IOkHttpCallback() {
            @Override
            public void onSuccess(Object result) {
                if (iRequestCallback != null) {
                    iRequestCallback.onSuccess(result);
                }
            }

            @Override
            public void onFailed(String error) {
                if (iRequestCallback != null) {
                    iRequestCallback.onFailed(error);
                }
            }
        });
    }
}
