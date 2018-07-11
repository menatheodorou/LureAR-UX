package com.lurear.setup;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.home.LARHomeActivity;
import com.lurear.home.nearby.LARLureNearbyActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by administrator on 10/13/2017.
 */

public class LARSetPreferencesActivity extends LARBaseActivity {


    @BindView(R.id.btMale)
    ImageView mIBMale;

    @BindView(R.id.btFemail)
    ImageView mIBFemale;

    @BindView(R.id.btTransGender)
    ImageView mIBTransGender;

    @BindView(R.id.btSave)
    ImageView mIBSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_preference);
        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(lp);

        tv.setText(R.string.set_prefer);
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        upArrow.setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_save, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.btSave:
                Intent intent = new Intent(LARSetPreferencesActivity.this, LARHomeActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @OnClick(R.id.btMale)
    void maleClickListener() {
        mIBMale.setImageResource(R.mipmap.ic_btn_male_ena);
        mIBFemale.setImageResource(R.mipmap.ic_btn_femail_dis);
        mIBTransGender.setImageResource(R.mipmap.ic_btn_transgender_dis);
    }

    @OnClick(R.id.btFemail)
    void femaleClickListener() {
        mIBMale.setImageResource(R.mipmap.ic_btn_male_dis);
        mIBFemale.setImageResource(R.mipmap.ic_btn_femail_ena);
        mIBTransGender.setImageResource(R.mipmap.ic_btn_transgender_dis);
    }

    @OnClick(R.id.btTransGender)
    void selectGeoFenceClickListener() {
        mIBMale.setImageResource(R.mipmap.ic_btn_male_dis);
        mIBFemale.setImageResource(R.mipmap.ic_btn_femail_dis);
        mIBTransGender.setImageResource(R.mipmap.ic_btn_transgender_ena);
    }

    @OnClick(R.id.btSave)
    void onSaveClicked(View view) {
        Intent intent = new Intent(LARSetPreferencesActivity.this, LARLureNearbyActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean supportOffline() {
        return false;
    }
}
