package com.example.a8866352155.beaconrestaurant;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.estimote.sdk.EstimoteSDK;
import com.example.a8866352155.beaconrestaurant.Beacon_Package.BeaconID;
import com.example.a8866352155.beaconrestaurant.Beacon_Package.BeaconNotificationsManager;

public class TestService extends Service {
    private boolean beaconNotificationsEnabled = false;
    public TestService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EstimoteSDK.initialize(getApplicationContext(), "<#App ID#>", "<#App Token#>");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
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
