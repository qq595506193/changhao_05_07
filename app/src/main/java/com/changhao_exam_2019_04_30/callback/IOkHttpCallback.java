package com.changhao_exam_2019_04_30.callback;

public interface IOkHttpCallback {
    void onSuccess(Object result);

    void onFailed(String error);
}
