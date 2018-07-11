package com.lurear.home.powershop;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.home.LARHomeSideMenuActivity;

public class LARPowerShopActivity extends LARBaseActivity {
    GridView androidGridView;
    Integer[] imageIDs = {
            R.mipmap.ic_shop_1, R.mipmap.ic_shop_2,R.mipmap.ic_shop_3,R.mipmap.ic_shop_4,R.mipmap.ic_shop_4,R.mipmap.ic_shop_4,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_shop);
        Toolbar mtoolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upHome = getResources().getDrawable(R.mipmap.ic_btn_left_side);
        getSupportActionBar().setHomeAsUpIndicator(upHome);
        androidGridView = (GridView) findViewById(R.id.gridView);
        androidGridView.setAdapter(new ImageAdapterGridView(this));
    }
    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT ));
                //mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mImageView.setAdjustViewBounds(true);
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageIDs[position]);
            return mImageView;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(LARPowerShopActivity.this, LARHomeSideMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
        return true;
    }
    @Override
    public boolean supportOffline() {
        return false;
    }
}
