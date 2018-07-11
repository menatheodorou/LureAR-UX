package com.lurear.onboard.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.app.LARConst;
import com.lurear.base.LARBaseActivity;
import com.lurear.signup.ui.LARSignInActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by administrator on 8/3/17.
 */

public class LAROnboardActivity extends LARBaseActivity {
    @BindView(R.id.tvSkip)
    TextView tvSkip;

    FragmentPagerAdapter adapterViewPager;
    private TextView[] dots;

    @BindView(R.id.llDots)
    LinearLayout llDots;

    @BindView(R.id.vpPager)
    ViewPager vpPager;

    @Override
    public boolean supportOffline() {
        return false;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_onboard);

//        getSupportActionBar().hide();

        vpPager.setClipToPadding(false);
        vpPager.setPadding(LARConst.ONBOARD_PADDING,0,LARConst.ONBOARD_PADDING,0);
        //vpPager.setPageMargin(20);

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setPageTransformer(true, new ExpandingViewPagerTransformer());
        vpPager.setAdapter(adapterViewPager);
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here

            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
                if (state==2){
                    vpPager.setPageTransformer(true, new ExpandingViewPagerTransformer1());
                }
                else if(state==0){
                    vpPager.setPageTransformer(true, new ExpandingViewPagerTransformer());
                }
            }
        });
        addBottomDots(0);
    }

    @OnClick(R.id.tvSkip)
    void onLoginClicked(View view) {
        Intent intent = new Intent(LAROnboardActivity.this, LARSignInActivity.class);
        startActivity(intent);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return LARFirstFragment.newInstance();
                case 1:
                    return LARSecondFragment.newInstance();
                case 2:
                    return LARThirdFragment.newInstance();
                case 3:
                    return LARFirstFragment.newInstance();
                default:
                    return null;
            }
        }
    }
    private void addBottomDots(int currentPage) {
        dots = new TextView[4];

        llDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(LARConst.ONBOARD_DOTSIZE1);
            dots[i].setTextColor(Color.parseColor(LARConst.ONBOARD_DOTCOLOR));
            llDots.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[currentPage].setTextSize(LARConst.ONBOARD_DOTSIZE2);
    }
    public class ExpandingViewPagerTransformer implements ViewPager.PageTransformer {

        public static final float MAX_SCALE = 1.0f;
        public static final float MIN_SCALE = 0.8f;

        @Override
        public void transformPage(View page, float position) {

            position = position < -1 ? -1 : position;
            position = position > 1 ? 1 : position;

            float tempScale = position < 0 ? 1 + position : 1 - position;

            float slope = (MAX_SCALE - MIN_SCALE) / 1;
            float scaleValue = MIN_SCALE + tempScale * slope;
            page.setScaleX(scaleValue);
            page.setScaleY(scaleValue);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                page.getParent().requestLayout();
            }
        }
    }
    public class ExpandingViewPagerTransformer1 implements ViewPager.PageTransformer {

        public static final float MAX_SCALE = 1.0f;
        public static final float MIN_SCALE = 0.8f;

        @Override
        public void transformPage(View page, float position) {

            position = position < -1 ? -1 : position;
            position = position > 1 ? 1 : position;

            float tempScale = position < 0 ? 1 + position : 1 - position;
            tempScale = tempScale >0.5 ? 1 : 0;
            float slope = (MAX_SCALE - MIN_SCALE) / 1;
            float scaleValue = MIN_SCALE + tempScale * slope;
            page.setScaleX(scaleValue);
            page.setScaleY(scaleValue);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                page.getParent().requestLayout();
            }
        }
    }
}