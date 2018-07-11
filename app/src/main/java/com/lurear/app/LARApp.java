package com.lurear.app;

import android.app.Activity;

import com.gpit.android.app.BaseApp;
import com.gpit.android.app.BaseConst;

import net.ralphpina.permissionsmanager.PermissionsManager;

/**
 * Created by administrator on 8/3/17.
 */

public class LARApp extends BaseApp {
    private boolean mIsLoggedIn = false;

    @Override
    public void onCreate() {
        // Init const first
        LARConst.init(this);

        // Enable remote logging system
        // RemoteLogger.enableRemoteLogs(true);

        super.onCreate();

        PermissionsManager.init(this);
    }

    @Override
    public Class<? extends Activity> getMainActivityClass() {
        return LARSplashActivity.class;
    }

    @Override
    public Class<? extends BaseConst> getConstClass() {
        return LARConst.class;
    }
}
