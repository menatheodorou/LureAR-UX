package com.lurear.signup.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.setup.LARAddProfilePictureActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LARSignInActivity extends LARBaseActivity {
    @BindView(R.id.btLogin)
    Button mIBLogin;

    @BindView(R.id.btFacebook)
    Button mIBFacebook;

    @BindView(R.id.btGoogle)
    Button mIBGoogle;

    @BindView(R.id.tvSignup)
    TextView mTVSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);
    }

    @Override
    public boolean supportOffline() {
        return false;
    }

    @OnClick (R.id.btLogin)
    void onLoginClicked(View view) {
//        Intent intent = new Intent(LARSignInActivity.this, LARAddProfilePictureActivity.class);
//        startActivity(intent);
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

    @OnClick (R.id.tvSignup)
    void onSignInClicked(View view) {
        Intent intent = new Intent(LARSignInActivity.this, LARSignUpActivity.class);
        startActivity(intent);
    }
}
