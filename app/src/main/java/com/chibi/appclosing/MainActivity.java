package com.chibi.appclosing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private TextView txt_click,txt_second;
    private WifiReceiver receiver;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_click = findViewById(R.id.txt_click);
        txt_second = findViewById(R.id.txt_second);
        receiver = new WifiReceiver();
        myApplication = MyApplication.getInstance();

        txt_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        });

        txt_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause");
        myApplication.onActivityPaused(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        showToast("onPostResume");
        myApplication.onActivityResumed(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("Destroy");
        unregisterReceiver(receiver);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart");
        registerReceiver();
    }

    private void registerReceiver() {
        if(receiver != null){
            IntentFilter filter = new IntentFilter();
            filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
            registerReceiver(receiver, filter);
        }
    }
}
