package com.lurear.signup.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.setup.LARAddProfilePictureActivity;
import com.lurear.setup.LARPersonalInfoActivity;
import com.lurear.setup.LARSetPreferencesActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LARSignUpActivity extends LARBaseActivity {
    @BindView(R.id.btRegister)
    Button mIBRegister;

    @BindView(R.id.btFacebook)
    Button mIBFacebook;

    @BindView(R.id.btGoogle)
    Button mIBGoogle;

    @BindView(R.id.tvSignIn)
    TextView mTVSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    @Override
    public boolean supportOffline() {
        return false;
    }

    @OnClick(R.id.btRegister)
    void onRegisterClicked(View view) {
        Intent intent = new Intent(LARSignUpActivity.this, LARAddProfilePictureActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.btFacebook)
    void onFacebookClicked(View view) {
        // Intent intent = new Intent(LARSignInActivity.this, LARSignUpActivity.class);
        // startActivity(intent);
    }

    @OnClick (R.id.btGoogle)
    void onGoogleClicked(View view) {
        // Intent intent = new Intent(LARSignInActivity.this, LARSignUpActivity.class);
        // sta1rtActivity(intent);
    }

    @OnClick(R.id.tvSignIn)
    void onSignInClicked(View view) {
        Intent intent = new Intent(LARSignUpActivity.this, LARSignInActivity.class);
        startActivity(intent);
    }
}
