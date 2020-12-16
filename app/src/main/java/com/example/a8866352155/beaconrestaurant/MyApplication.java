package com.example.a8866352155.beaconrestaurant;

import android.app.Application;

import com.estimote.sdk.EstimoteSDK;
import com.example.a8866352155.beaconrestaurant.Beacon_Package.BeaconID;
import com.example.a8866352155.beaconrestaurant.Beacon_Package.BeaconNotificationsManager;

/**
 * Created by 8866352155 on 3/24/2017.
 */

public class MyApplication extends Application {
    private boolean beaconNotificationsEnabled = false;

    @Override
    public void onCreate() {
        super.onCreate();

        // TODO: put your App ID and App Token here
        // You can get them by adding your app on https://cloud.estimote.com/#/apps
        EstimoteSDK.initialize(getApplicationContext(), "<#App ID#>", "<#App Token#>");

        // uncomment to enable debug-level logging
        // it's usually only a good idea when troubleshooting issues with the Estimote SDK
//        EstimoteSDK.enableDebugLogging(true);

    }

    public void enableBeaconNotifications() {
        if (beaconNotificationsEnabled) { return; }

        BeaconNotificationsManager beaconNotificationsManager = new BeaconNotificationsManager(this);
        beaconNotificationsManager.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 2, 2),
                "Hello, Welocme to Beacon Restaurant.",
                "Goodbye, User. See you SOON");
        beaconNotificationsManager.startMonitoring();

        beaconNotificationsEnabled = true;
    }

    public boolean isBeaconNotificationsEnabled() {
        return beaconNotificationsEnabled;
    }
}
