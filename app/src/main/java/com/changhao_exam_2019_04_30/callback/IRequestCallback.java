package com.changhao_exam_2019_04_30.callback;

public interface IRequestCallback {
    void onSuccess(Object result);

    void onFailed(String error);
}
