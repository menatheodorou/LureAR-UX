package com.lurear.setup;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by administrator on 10/13/2017.
 */

public class LARAddProfilePictureActivity extends LARBaseActivity {
    @BindView(R.id.btTakePhoto)
    ImageView mIBTakePhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile_picture);
        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        LayoutParams lp = new RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, // Width of TextView
                LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(lp);

        tv.setText(R.string.profile_picture);
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
    }

    @Override
    public boolean supportOffline() {
        return false;
    }

    @OnClick(R.id.btTakePhoto)
    void onTakePhotoClicked(View view) {
        Intent intent = new Intent(LARAddProfilePictureActivity.this, LARPersonalInfoActivity.class);
        startActivity(intent);
    }
}
