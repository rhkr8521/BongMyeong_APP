package com.rhkr8521.bongmyeong.tool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Tools {

    public static boolean isOnline(Context mContext) {
        ConnectivityManager mManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = mManager.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static boolean isWifi(Context mContext) {
        ConnectivityManager manager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return wifi.isConnected();
    }
}
