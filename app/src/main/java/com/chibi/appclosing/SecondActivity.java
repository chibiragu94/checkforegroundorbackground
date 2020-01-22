package com.chibi.appclosing;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class SecondActivity extends AppCompatActivity {

    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myApplication = MyApplication.getInstance();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //showToast("onPause");
        myApplication.onActivityPaused(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //showToast("onPostResume");
        myApplication.onActivityResumed(this);
    }


}
