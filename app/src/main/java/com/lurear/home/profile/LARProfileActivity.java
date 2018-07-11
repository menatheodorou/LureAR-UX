package com.lurear.home.profile;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.home.LARHomeSideMenuActivity;
import com.lurear.signup.ui.LARSignInActivity;

import java.util.ArrayList;

import butterknife.OnClick;

public class LARProfileActivity extends LARBaseActivity {

    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_profile);
        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(LARProfileActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        //Set False ListView
        ExpandList.expandGroup(0);
        ExpandList.expandGroup(1);
        //Set Group Indicator...
        ExpandList.setGroupIndicator(null);
        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(lp);

        tv.setText(R.string.profile);
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.mipmap.ic_btn_left_side);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @OnClick(R.id.tvlogout)
    public void logoutclick()
    {
        Intent intent = new Intent(LARProfileActivity.this, LARSignInActivity.class);
        startActivity(intent);
    }
    //Set Data to ExpandableListView..
    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = { "PERSONAL INFO","" };

        String personal_item[] = {"Age", "Gender", "Interests"};
        int image = R.mipmap.ic_arrow;
        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;



        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            int j = 0;
            if (gru.getName().equals("PERSONAL INFO")){
                for (; j < personal_item.length; j++) {
                    Child ch = new Child();
                    ch.setName(personal_item[j]);
                    ch.setImage(image);
                    ch_list.add(ch);
                }
            }
            gru.setItems(ch_list);
            list.add(gru);
        }

        return list;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(LARProfileActivity.this, LARHomeSideMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
        return true;
    }
    @Override
    public boolean supportOffline() {
        return false;
    }
}
