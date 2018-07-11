package com.lurear.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.home.broadcast.LARNoBroadcastActivity;
import com.lurear.home.checkinout.LARCheckInOutActivity;
import com.lurear.home.geofence.LARGeoFenceActivity;
import com.lurear.home.nearby.LARLureNearbyActivity;
import com.lurear.home.powershop.LARPowerShopActivity;
import com.lurear.home.profile.LARProfileActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LARHomeSideMenuActivity extends LARBaseActivity {
    @BindView(R.id.btHomeMenu)
    TextView mIBHomeMenu;

    @BindView(R.id.btCheckInOut)
    TextView mIBCheckInOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }

    @OnClick(R.id.btHomeMenu)
    void homeMenuClickListener() {
        finish();
        Intent intent = new Intent(LARHomeSideMenuActivity.this, LARHomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }

    @OnClick(R.id.btCheckInOut)
    void checkInOutClickListener() {
        finish();
        Intent intent = new Intent(LARHomeSideMenuActivity.this, LARCheckInOutActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }
    @OnClick(R.id.btLureNearby)
    void lureNearbyClickListener() {
        finish();
        Intent intent = new Intent(LARHomeSideMenuActivity.this, LARLureNearbyActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }
    @OnClick(R.id.btNoBroadcast)
    void noBroadcastClickListener(){
        finish();
        Intent intent = new Intent(LARHomeSideMenuActivity.this, LARNoBroadcastActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }
    @OnClick(R.id.btPowerShop)
    void onPowerShopClickListener(){
        finish();
        Intent intent = new Intent(LARHomeSideMenuActivity.this, LARPowerShopActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }
    @OnClick(R.id.btHomeProfile)
    void homeProfileClickListener() {
        finish();
        Intent intent = new Intent(LARHomeSideMenuActivity.this, LARProfileActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }
    @OnClick(R.id.btGeoFences)
    void geoFencesClickListener() {
        finish();
        Intent intent = new Intent(LARHomeSideMenuActivity.this, LARGeoFenceActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_rl, R.anim.exit_rl);
    }
    @Override
    public boolean supportOffline() {
        return false;
    }
}
