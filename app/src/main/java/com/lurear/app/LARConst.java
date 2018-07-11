package com.lurear.app;

import android.content.Context;

import com.gpit.android.app.BaseConst;
import com.gpit.android.logger.RemoteLogger;
import com.lurear.BuildConfig;

/**
 * Created by administrator on 8/3/17.
 */

public class LARConst extends BaseConst {
    private final static String TAG = LARConst.class.getSimpleName();

    public static String WEB_API_SERVER_URL;
    public final static String DEV_WEB_API_SERVER_URL = "https://lurear.com";
    public final static String PRODUCT_WEB_API_SERVER_URL = "https://lurear.com";
    public final static int ONBOARD_PADDING=60;
    public final static float ONBOARD_DOTSIZE1=35;
    public final static float ONBOARD_DOTSIZE2=50;
    public final static String ONBOARD_DOTCOLOR="#f2f4f4";
    public static void init(Context context) {
        RemoteLogger.d(TAG, "Init constant");

        // DEV_REMOTE_LOGGER_TOKEN = "e1284a36-5709-4420-bb98-71c63d79cafd";
        // PRODUCTION_REMOTE_LOGGER_TOKEN = "2ed2cd5e-36a0-4560-8fdf-239e958997ee";
        PRODUCTION_REMOTE_LOGGER_LOGGING_LEVEL = LogLevel.LOG_LEVEL_DEBUG;

        // DEV_MINT_TOKEN = "627eb1ef";
        // PRODUCTION_MINT_TOKEN = "4d0b5f57";

        DEV_MODE_ON = BuildConfig.DEBUG;

        if (DEV_MODE_ON) {
            WEB_API_SERVER_URL = DEV_WEB_API_SERVER_URL;
        } else {;
            WEB_API_SERVER_URL = PRODUCT_WEB_API_SERVER_URL;
        }

        BaseConst.init(context);
    }
}
