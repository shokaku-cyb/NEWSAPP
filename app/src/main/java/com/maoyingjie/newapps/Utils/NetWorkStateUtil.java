package com.maoyingjie.newapps.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

import com.maoyingjie.newapps.App;

public class NetWorkStateUtil {

    public static Boolean isWiFiAvailable() {
        ConnectivityManager manager = (ConnectivityManager) App.ApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (info != null) {
            return info.isAvailable();
        } else
            return false;
    }

    public static boolean isMobileConnected() {

        ConnectivityManager mConnectivityManager = (ConnectivityManager) App.ApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mMobileNetworkInfo = mConnectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mMobileNetworkInfo != null) {
            return mMobileNetworkInfo.isAvailable();
        } else
            return false;
    }

    public static boolean isNetWorking() {
        if (NetWorkStateUtil.isMobileConnected()||NetWorkStateUtil.isWiFiAvailable())
            return true;
        else return false;
    }
}
