package com.lurear.home.nearby;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
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
import com.lurear.home.LARHomeActivity;

import java.util.ArrayList;
import java.util.List;


public class LARLureNearbyActivity extends LARBaseActivity {
    List products;
    ListView gvProducts = null;
    LARProductListAdapterWithCache adapterProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_larlure_nearby);
        TextView tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setText(R.string.lure_nearby);
        tv.setTextColor(Color.BLACK);
        tv.setGravity(Gravity.CENTER);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
        products= new ArrayList();
        products.add(new LARProduct("Natalie","http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg"));
        products.add(new LARProduct("Alena","http://farm4.staticflickr.com/3139/2780642603_8d2c90e364_s.jpg"));
        products.add(new LARProduct("Nicki", "http://farm2.staticflickr.com/1008/1420343003_13eeb0f9f3_s.jpg"));
        products.add(new LARProduct("Michelle", "http://farm5.staticflickr.com/4118/4784687474_0eca8226b0_z.jpg"));
        gvProducts = (ListView) findViewById( R.id.lurenearby_list2);
        adapterProducts = new LARProductListAdapterWithCache(this, products);
        gvProducts.setAdapter(adapterProducts);
        products = new ArrayList();
        products.add(new LARProduct("Lina","http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg"));
        products.add(new LARProduct("Julia", "http://farm4.staticflickr.com/3139/2780642603_8d2c90e364_s.jpg"));
        products.add(new LARProduct("Caroline", "http://farm2.staticflickr.com/1008/1420343003_13eeb0f9f3_s.jpg"));
        gvProducts = (ListView) findViewById( R.id.lurenearby_list1);
        adapterProducts = new LARProductListAdapterWithCache(this, products);
        gvProducts.setAdapter(adapterProducts);
        products = new ArrayList();
        products.add(new LARProduct("Rita","http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg"));
        products.add(new LARProduct("Selena","http://farm4.staticflickr.com/3139/2780642603_8d2c90e364_s.jpg"));
        products.add(new LARProduct("Natalia", "http://farm2.staticflickr.com/1008/1420343003_13eeb0f9f3_s.jpg"));
        gvProducts = (ListView) findViewById( R.id.lurenearby_list3);
        adapterProducts = new LARProductListAdapterWithCache(this, products);
        gvProducts.setAdapter(adapterProducts);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.btSave:
                Intent intent = new Intent(LARLureNearbyActivity.this, LARHomeActivity.class);
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
}
