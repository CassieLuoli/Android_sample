package com.huawei.sirius.thinktank.shared.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.huawei.sirius.thinktank.application.ThinkTankApp;

/**
 * Created by Luoli on 7/27/16.
 */
public class PreferenceUtil {

    public static final String SETTING = "SETTING";
    public static final String USER_ACCOUNT = "USER_ACCOUNT";

    public static void save(String key, String value){
        SharedPreferences setting = ThinkTankApp.getContext().getSharedPreferences(SETTING, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = setting.edit();
        editor.putString(USER_ACCOUNT, value);
        editor.apply();
    }

}
