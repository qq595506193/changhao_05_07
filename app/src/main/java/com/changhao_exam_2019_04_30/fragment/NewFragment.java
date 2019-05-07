package com.changhao_exam_2019_04_30.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.changhao_exam_2019_04_30.R;
import com.changhao_exam_2019_04_30.adapter.HomeAdapter;
import com.changhao_exam_2019_04_30.contract.HomeContract;
import com.changhao_exam_2019_04_30.entity.HomeBean;
import com.changhao_exam_2019_04_30.presenter.HomePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.stx.xhb.xbanner.XBanner;

import java.util.HashMap;
import java.util.List;

public class NewFragment extends Fragment implements HomeContract.IHomeView {
    private View view;
    private XBanner mHomeBanner;
    private RelativeLayout mFra01Rela;
    private RecyclerView mRvInformationHome;
    private SmartRefreshLayout mRefreshLayout;
    private HomeAdapter homeAdapter;
    private HomePresenter homePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initData() {
        HashMap<String, Object> params = new HashMap<>();
        homePresenter.getHome(params);
    }

    private void initView(View view) {

        initFindViewById(view);
        homePresenter = new HomePresenter(this);
        homeAdapter = new HomeAdapter(getActivity());
        mRvInformationHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvInformationHome.setAdapter(homeAdapter);
    }

    private void initFindViewById(View view) {
        mHomeBanner = (XBanner) view.findViewById(R.id.home_banner);
        mFra01Rela = (RelativeLayout) view.findViewById(R.id.fra01_rela);
        mRvInformationHome = (RecyclerView) view.findViewById(R.id.rv_information_home);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
    }

    @Override
    public void onSuccess(Object homeBean) {
        Log.i("TAG", homeBean + "");
        if (homeBean instanceof HomeBean) {
            List<List<HomeBean.ResultBean.VideoBean>> video = ((HomeBean) homeBean).result.video;
            homeAdapter.setHomeBean(video);

        }
    }

    @Override
    public void onFailed(String error) {

    }
}
