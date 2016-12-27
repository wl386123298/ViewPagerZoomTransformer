package com.watch.animal;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @Author: wliang.
 * @Date: 2016/12/22 0022 14:48
 * @E-mail: wl386123298@qq.com
 */
public class WatchDetailActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private View mViewRoot;
    private int position ;
    private int[] colors = {Color.parseColor("#FF4081"), Color.RED, Color.BLUE, Color.parseColor("#7061E0"), Color.parseColor("#3F51B5")};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_layout);

        mViewRoot = findViewById(R.id.viewRoot);

        mViewPager = (ViewPager) findViewById(R.id.watchViewPager);
        mViewPager.setPageMargin(150);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(this);
        ParallaxTransformer transformer = new ParallaxTransformer(1.0f, 0.5f);
        mViewPager.setPageTransformer(true ,transformer);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.position = position;
        ArgbEvaluator evaluator = new ArgbEvaluator(); // ARGB求值器
        int evaluate = colors[0]; // 初始默认颜色（透明白）
        int startColor =  colors[this.position <= 0 ? 0 : position];
        int endColor;
        if (position == 0){
            endColor = colors[position +1];
        }else {
            endColor = colors[position +1 >=colors.length ? colors.length -1 : position +1];
        }

        evaluate = (Integer) evaluator.evaluate(positionOffset, startColor, endColor); // 根据positionOffset和第0页~第1页的颜色转换范围取颜色值
        mViewRoot.setBackgroundColor(evaluate);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(evaluate);
        }

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private WatchFragment watchFragment;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            watchFragment = (WatchFragment) Fragment.instantiate(WatchDetailActivity.this, WatchFragment.class.getName());
            watchFragment.setPosition(position);
            return watchFragment;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
