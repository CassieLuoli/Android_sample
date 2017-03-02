package com.hw.sirius.thinktank.application;

import android.app.Application;

public class ThinkTankApp extends Application {

    private static ThinkTankApp context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    private ThinkTankApp() {
    }

    public static ThinkTankApp getContext() {
        return context;
    }
}
