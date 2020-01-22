package com.chibi.appclosing;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {

    public String currentActivity;
    private static MyApplication instance;
    //private static WeakReference<Activity> currentActivityReference;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        this.registerActivityLifecycleCallbacks(this);
    }

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

        currentActivity = activity.getLocalClassName();
        //Toast.makeText(activity,"resume: "+activity.getLocalClassName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        currentActivity = null;
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }
}
