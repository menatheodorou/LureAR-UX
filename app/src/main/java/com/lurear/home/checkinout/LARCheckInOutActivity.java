package com.lurear.home.checkinout;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.home.LARHomeSideMenuActivity;
import com.lurear.model.LARCheckInOutAdapter;
import com.lurear.model.LARCheckInOutModel;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class LARCheckInOutActivity extends LARBaseActivity {



    @BindView(R.id.btCheckIn)
    ImageView mIBCheckIn;

    @BindView(R.id.btCheckOut)
    ImageView mIBCheckOut;


    ListView checkInOutList;
    ArrayList<LARCheckInOutModel> checkItemsList=new ArrayList<>();

    @Override
    public boolean supportOffline() {
        return false;
    }

    @OnClick(R.id.btCheckIn)
    void btCheckInClickListener() {

        mIBCheckIn.setImageResource(R.mipmap.ic_btn_checkin_ena);
        mIBCheckOut.setImageResource(R.mipmap.ic_btn_checkout_dis);
        LinearLayout item = (LinearLayout)findViewById(R.id.layoutListView);
        item.removeAllViewsInLayout();
        View child = getLayoutInflater().inflate(R.layout.fragment_listview, null);
        item.addView(child);

        checkInOutList = (ListView) findViewById(R.id.checkInOutListView);
        LARCheckInOutAdapter myAdapter=new LARCheckInOutAdapter(this,R.layout.fragment_list_cell,checkItemsList);
        checkInOutList.setAdapter(myAdapter);

    }

    @OnClick(R.id.btCheckOut)
    void btCheckOutClickListener() {

        mIBCheckIn.setImageResource(R.mipmap.ic_btn_checkin_dis);
        mIBCheckOut.setImageResource(R.mipmap.ic_btn_checkout_ena);

        LinearLayout item = (LinearLayout)findViewById(R.id.layoutListView);
        item.removeAllViewsInLayout();
        View child = getLayoutInflater().inflate(R.layout.fragment_checkout, null);
        item.addView(child);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_out);
        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(lp);
        //tv.setBackgroundColor(Color.BLACK);
        tv.setText(R.string.check_in_out);
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.mipmap.ic_btn_left_side);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        LinearLayout item = (LinearLayout)findViewById(R.id.layoutListView);
        View child = getLayoutInflater().inflate(R.layout.fragment_listview, null);
        item.addView(child);

//        ListView checkInOutList;
//        ArrayList<LARCheckInOutModel> animalList=new ArrayList<>();
        checkInOutList = (ListView) findViewById(R.id.checkInOutListView);
        checkItemsList.add(new LARCheckInOutModel("Park Plaza","24th Jul","02:00 PM"));
        checkItemsList.add(new LARCheckInOutModel("Hyatt Regency","25th Jul","03:10 PM"));
        checkItemsList.add(new LARCheckInOutModel("Taj Villas","26th Jul","02:00 PM"));
        checkItemsList.add(new LARCheckInOutModel("Le Meridian","27th Jul","05:00 PM"));
        checkItemsList.add(new LARCheckInOutModel("Plaza Port Luxary","28th Jul","06:00 AM"));
        checkItemsList.add(new LARCheckInOutModel("Park Plaza","24th Jul","02:00 PM"));
        checkItemsList.add(new LARCheckInOutModel("Hyatt Regency","25th Jul","03:10 PM"));
        checkItemsList.add(new LARCheckInOutModel("Taj Villas","26th Jul","02:00 PM"));
        checkItemsList.add(new LARCheckInOutModel("Le Meridian","27th Jul","05:00 PM"));
        checkItemsList.add(new LARCheckInOutModel("Plaza Port Luxary","28th Jul","06:00 AM"));

        LARCheckInOutAdapter myAdapter=new LARCheckInOutAdapter(this,R.layout.fragment_list_cell,checkItemsList);
        checkInOutList.setAdapter(myAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(LARCheckInOutActivity.this, LARHomeSideMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
        return true;
    }

}
