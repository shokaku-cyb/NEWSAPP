package com.maoyingjie.newapps;

import android.app.Application;
import android.content.Context;

import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

public class App extends Application {
    private static Context application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = getApplicationContext();
        RxJavaPlugins.setErrorHandler(throwable -> {
            throwable.printStackTrace();
        });
    }

    public static Context ApplicationContext() {
        return application;
    }
}
