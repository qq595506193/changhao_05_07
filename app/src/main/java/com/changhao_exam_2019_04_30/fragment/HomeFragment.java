package com.changhao_exam_2019_04_30.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.changhao_exam_2019_04_30.R;

public class HomeFragment extends Fragment {
    private View view;
    /**
     * 最新日报
     */
    private RadioButton mRadioBtnNew;
    /**
     * 专栏
     */
    private RadioButton mRadioBtnNew02;
    /**
     * 热门
     */
    private RadioButton mRadioBtnNew03;
    /**
     * 主题日报
     */
    private RadioButton mRadioBtnNew04;
    private RadioGroup mViewGroup;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
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

    }

    private void initView(View view) {

        initFindViewById(view);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        mViewGroup.check(R.id.radio_btn_new);
                        break;
                    case 1:
                        mViewGroup.check(R.id.radio_btn_new02);
                        break;
                    case 2:
                        mViewGroup.check(R.id.radio_btn_new03);
                        break;
                    case 3:
                        mViewGroup.check(R.id.radio_btn_new04);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mViewGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_btn_new:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.radio_btn_new02:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.radio_btn_new03:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.radio_btn_new04:
                        mViewPager.setCurrentItem(3);
                        break;
                }
            }
        });

        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i) {
                    case 0:
                        return new NewFragment();
                    case 1:
                        return new New02Fragment();
                    case 2:
                        return new New03Fragment();
                    case 3:
                        return new New04Fragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
    }

    private void initFindViewById(View view) {
        mRadioBtnNew = (RadioButton) view.findViewById(R.id.radio_btn_new);
        mRadioBtnNew02 = (RadioButton) view.findViewById(R.id.radio_btn_new02);
        mRadioBtnNew03 = (RadioButton) view.findViewById(R.id.radio_btn_new03);
        mRadioBtnNew04 = (RadioButton) view.findViewById(R.id.radio_btn_new04);
        mViewGroup = (RadioGroup) view.findViewById(R.id.view_group);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
    }


}
