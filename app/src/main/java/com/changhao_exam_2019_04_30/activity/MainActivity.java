package com.changhao_exam_2019_04_30.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.changhao_exam_2019_04_30.R;
import com.changhao_exam_2019_04_30.activity.base.BaseActivity;
import com.changhao_exam_2019_04_30.fragment.HomeFragment;
import com.changhao_exam_2019_04_30.fragment.OtherFragment;

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    /**
     * 首页
     */
    private RadioButton mRadioBtnHome;
    /**
     * 其他01
     */
    private RadioButton mRadioBtnOther01;
    /**
     * 其他02
     */
    private RadioButton mRadioBtnOther02;
    private RadioGroup mRadioGroup;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        initFindViewById();

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        mRadioGroup.check(R.id.radio_btn_home);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.radio_btn_other01);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.radio_btn_other02);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_btn_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.radio_btn_other01:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.radio_btn_other02:
                        mViewPager.setCurrentItem(2);
                        break;
                }
            }
        });

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                if (i == 0) {
                    return new HomeFragment();
                }
                return new OtherFragment();
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    private void initFindViewById() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mRadioBtnHome = (RadioButton) findViewById(R.id.radio_btn_home);
        mRadioBtnOther01 = (RadioButton) findViewById(R.id.radio_btn_other01);
        mRadioBtnOther02 = (RadioButton) findViewById(R.id.radio_btn_other02);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
    }

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }

}
