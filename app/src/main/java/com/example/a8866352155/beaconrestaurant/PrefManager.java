package com.example.a8866352155.beaconrestaurant;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 8866352155 on 2/15/2017.
 */

public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "Beacon Restaurant";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch()
    {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
