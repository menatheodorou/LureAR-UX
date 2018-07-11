package com.lurear.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gpit.android.ui.common.BaseActivity;
import com.lurear.R;


import butterknife.ButterKnife;

/**
 * Created by administrator on 8/3/17.
 */

public abstract class LARBaseActivity extends BaseActivity {
    /*
    @Override
    public void onUserInteraction(){
        super.onUserInteraction();
        resetDisconnectTimer();
    }
    */

    public boolean isLockable() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                // NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    @CallSuper
    protected void initUI() {
        ButterKnife.bind(this);

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        */
    }

    @CallSuper
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
    }
}
