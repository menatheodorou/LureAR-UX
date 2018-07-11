package com.lurear.home.geofence;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.home.LARHomeSideMenuActivity;
import com.lurear.model.LARGeoFenceAdapter;
import com.lurear.model.LARGeoFenceModel;

import java.util.ArrayList;


public class LARGeoFenceActivity extends LARBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_fence);

        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(lp);

        tv.setText(R.string.geo_fence);
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.mipmap.ic_btn_left_side);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

//        LinearLayout item = (LinearLayout)findViewById(R.id.layoutListView);
//        View child = getLayoutInflater().inflate(R.layout.activity_geo_fence, null);
//        item.addView(child);

        ListView geoListView;
        ArrayList<LARGeoFenceModel> geoItemsList=new ArrayList<>();

        geoListView = (ListView) findViewById(R.id.geoFenceListView);
        geoItemsList.add(new LARGeoFenceModel("Home","24 Street,Allabella,NYC, United States","200Mtr"));
        geoItemsList.add(new LARGeoFenceModel("Work-Place","24 Street,Allabella,NYC, United States","200Mtr"));
        geoItemsList.add(new LARGeoFenceModel("Gym","24 Street,Allabella,NYC, United States","200Mtr"));
        geoItemsList.add(new LARGeoFenceModel("Home2","24 Street,Allabella,NYC, United States","200Mtr"));
        geoItemsList.add(new LARGeoFenceModel("Friends Resi","24 Street,Allabella,NYC, United States","200Mtr"));

        LARGeoFenceAdapter myAdapter=new LARGeoFenceAdapter(this,R.layout.fragment_geofence_list_cell,geoItemsList);
        geoListView.setAdapter(myAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(LARGeoFenceActivity.this, LARHomeSideMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
        return true;
    }

    @Override
    public boolean supportOffline() {
        return false;
    }

}
