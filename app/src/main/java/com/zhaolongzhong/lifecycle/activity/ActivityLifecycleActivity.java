package com.zhaolongzhong.lifecycle.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhaolongzhong.lifecycle.R;

/**
 * Created by Zhaolong Zhong on 6/9/16.
 */
public class ActivityLifecycleActivity extends AppCompatActivity {
    private static final String TAG = ActivityLifecycleActivity.class.getSimpleName();

    private static final String STATE_SCORE = "score";
    private int currentScore;

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, ActivityLifecycleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Always call the superclass method first
        Log.d(TAG, "onCreate");

        if (savedInstanceState != null) {
            // Restore value from savedInstanceState
            currentScore = savedInstanceState.getInt(STATE_SCORE);
        } else {
            currentScore = 0; // Initialize currentScore
        }

        setContentView(R.layout.activity_lifecycle_activity);

        setTitle(getString(R.string.activity_lifecycle));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");

        // Activity being restarted from stopped state
        // This method will be called when this activity is waken up from stopped state.
        // When when activity is created for the first time, this method will not be called.
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

        // For example, when we use the Camera
        // We can get the Camera instance as the activity achieves full user focus.

//        if (camera == null) {
//            initializeCamera(); // Local method to handle camera init
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

        // For example, when we use the Camera
        // We need to release the Camera since we don't need it when paused
        // and other activities might need to use it.

//        if (camera != null) {
//            camera.release();
//            camera = null;
//        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

        // Save any process here
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // As the activity begins to stop, this method will be called,
        // so it's a good time to save user's info

        // Save the user's current game state
        savedInstanceState.putInt(STATE_SCORE, currentScore);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
