package com.chibi.appclosing;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class WifiReceiver extends BroadcastReceiver {

    // MyApplication mApplication;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {

            // mApplication = ((MyApplication) context.getApplicationContext());

            int extra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
            if (extra == WifiManager.WIFI_STATE_ENABLED) {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                launchWifiActivity(context);
            } else if (extra == WifiManager.WIFI_STATE_DISABLED) {
                Toast.makeText(context, "DisConnected", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void launchWifiActivity(Context context) {

        String currentActivity = MyApplication.getInstance().currentActivity;
        if (null == currentActivity) {
            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
