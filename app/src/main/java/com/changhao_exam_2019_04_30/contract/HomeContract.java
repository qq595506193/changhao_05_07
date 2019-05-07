package com.changhao_exam_2019_04_30.contract;

import com.changhao_exam_2019_04_30.callback.IRequestCallback;
import com.changhao_exam_2019_04_30.entity.HomeBean;

import java.util.HashMap;

public interface HomeContract {
    abstract class HomePresenter {
        public abstract void getHome(HashMap<String, Object> params);
    }

    interface IHomeModel {
        void getHome(HashMap<String, Object> params, IRequestCallback iRequestCallback);
    }

    interface IHomeView {
        void onSuccess(Object homeBean);

        void onFailed(String error);
    }
}
