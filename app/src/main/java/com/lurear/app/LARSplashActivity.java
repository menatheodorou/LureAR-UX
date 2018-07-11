package com.lurear.app;

import android.app.Activity;
import android.os.Bundle;

import com.gpit.android.ui.common.BaseSplashActivity;
import com.lurear.R;
import com.lurear.home.LARHomeActivity;
import com.lurear.onboard.ui.LAROnboardActivity;
import com.lurear.signup.ui.LARSignInActivity;

public class LARSplashActivity extends BaseSplashActivity {
    private final static int SPLASH_DISPLAY_LENGTH = 3;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public int getSplashTimeSeconds() {
        return SPLASH_DISPLAY_LENGTH;
    }

    @Override
    public Class<? extends Activity> getNextActivity() {
        return LAROnboardActivity.class;
//        return LARHomeActivity.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
