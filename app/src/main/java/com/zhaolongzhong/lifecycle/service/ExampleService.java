package com.zhaolongzhong.lifecycle.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.zhaolongzhong.lifecycle.fragment.FragmentLifecycleActivity;

/**
 * Created by Zhaolong Zhong on 6/9/16.
 *
 * Reference: https://developer.android.com/guide/components/services.html
 */
public class ExampleService extends Service {
    private static final String TAG = FragmentLifecycleActivity.ExampleFragment.class.getSimpleName();

    int mStartMode;       // indicates how to behave if the service is killed
    IBinder mBinder;      // interface for clients that bind
    boolean mAllowRebind; // indicates whether onRebind should be used

    @Override
    public void onCreate() {
        // The service is being created
        Log.d(TAG, "onCreate");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // The service is starting, due to a call to startService()
        Log.d(TAG, "onStartCommand");
        return mStartMode;
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        // A client is binding to the service with bindService()
        return mBinder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        // All clients have unbound with unbindService()
        return mAllowRebind;
    }
    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind");
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
    }
    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        // The service is no longer used and is being destroyed
    }
}