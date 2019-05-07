package com.changhao_exam_2019_04_30.service;

import com.changhao_exam_2019_04_30.entity.HomeBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface IRetrofitService {
    @POST
    Observable<HomeBean> doPost(@Url String apiUrl, @QueryMap HashMap<String, Object> params);
}
