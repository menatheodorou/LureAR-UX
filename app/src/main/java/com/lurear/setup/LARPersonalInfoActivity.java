package com.lurear.setup;

import android.app.ActionBar;
import android.content.Intent;

import android.graphics.Color;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import android.widget.TextView;

import com.lurear.R;
import com.lurear.app.LARCommon;
import com.lurear.base.LARBaseActivity;


import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.inflate;

/**
 * Created by administrator on 10/13/2017.
 */

public class LARPersonalInfoActivity extends LARBaseActivity {
//    @BindView(R.id.btSave)
//    TextView mIBSave;

    @BindView(R.id.btMale)
    ImageView mIBMale;

    @BindView(R.id.btFemail)
    ImageView mIBFemale;

    @BindView(R.id.btTransGender)
    ImageView mIBTransGender;
    @BindView(R.id.btn1)
    ImageView mIB1;
    @BindView(R.id.btn2)
    ImageView mIB2;
    @BindView(R.id.btn3)
    ImageView mIB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        TextView tv = new TextView(getApplicationContext());
        mIB3.setTag(0);
        mIB1.setTag(0);
        mIB2.setTag(0);
        LARCommon.setInterest1(0);
        LARCommon.setInterest2(0);
        LARCommon.setInterest3(0);
        LARCommon.setSelectinterest(0);
        // Create a LayoutParams for TextView
        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                ConstraintLayout.LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(lp);

        tv.setText(R.string.personal_info);
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back);
        upArrow.setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //Create a AddInterests
//
//        ListView checkInOutList;
//        ArrayList<LARAddGeoFenceModel> animalList=new ArrayList<>();
//        checkInOutList = (ListView) findViewById(R.id.checkInOutListView);
//        animalList.add(new LARAddGeoFenceModel("Park Plaza"));
//
//        LARAddGeoFenceAdapter myAdapter=new LARAddGeoFenceAdapter(this,R.layout.fragment_add_interest_cell,animalList);
//        checkInOutList.setAdapter(myAdapter);

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
                Intent intent = new Intent(LARPersonalInfoActivity.this, LARSetPreferencesActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean supportOffline() {
        return false;
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

    @OnClick(R.id.btn3)
    void addInterestsClickListener() {
        if (Integer.parseInt(mIB3.getTag().toString())==0){
            LARCommon.setSelectinterest(LARCommon.getInterest3());
            LARCommon.showAddInterestsDialog(LARPersonalInfoActivity.this,0);
        }
        else{
            LARCommon.setSelectinterest(LARCommon.getInterest3());
            LARCommon.showAddInterestsDialog(LARPersonalInfoActivity.this,3);
        }
    }
    @OnClick(R.id.btn2)
    void bt2ClickListener() {
        if (Integer.parseInt(mIB2.getTag().toString())==0) {
            LARCommon.setSelectinterest(LARCommon.getInterest2());
            LARCommon.showAddInterestsDialog(LARPersonalInfoActivity.this, 5);
        }else{
            LARCommon.setSelectinterest(LARCommon.getInterest2());
            LARCommon.showAddInterestsDialog(LARPersonalInfoActivity.this, 2);
        }
    }
    @OnClick(R.id.btn1)
    void bt3ClickListener() {
        if (Integer.parseInt(mIB1.getTag().toString())==0) {
            LARCommon.setSelectinterest(LARCommon.getInterest1());
            LARCommon.showAddInterestsDialog(LARPersonalInfoActivity.this, 4);
        }
        else {
            LARCommon.setSelectinterest(LARCommon.getInterest1());
            LARCommon.showAddInterestsDialog(LARPersonalInfoActivity.this, 1);
        }
    }
}
