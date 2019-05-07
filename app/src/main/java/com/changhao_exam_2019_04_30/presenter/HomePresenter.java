package com.changhao_exam_2019_04_30.presenter;

import com.changhao_exam_2019_04_30.callback.IRequestCallback;
import com.changhao_exam_2019_04_30.contract.HomeContract;
import com.changhao_exam_2019_04_30.model.HomeModel;

import java.util.HashMap;

public class HomePresenter extends HomeContract.HomePresenter {
    private HomeModel homeModel;
    private HomeContract.IHomeView iHomeView;

    public HomePresenter(HomeContract.IHomeView iHomeView) {
        homeModel = new HomeModel();
        this.iHomeView = iHomeView;
    }

    @Override
    public void getHome(HashMap<String, Object> params) {
        homeModel.getHome(params, new IRequestCallback() {
            @Override
            public void onSuccess(Object result) {
                if (iHomeView != null) {
                    iHomeView.onSuccess(result);
                }
            }

            @Override
            public void onFailed(String error) {
                if (iHomeView != null) {
                    iHomeView.onFailed(error);
                }
            }
        });
    }
}
