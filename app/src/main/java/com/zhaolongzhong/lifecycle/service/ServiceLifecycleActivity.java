package com.zhaolongzhong.lifecycle.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zhaolongzhong.lifecycle.R;

/**
 * Created by Zhaolong Zhong on 6/9/16.
 */

public class ServiceLifecycleActivity extends AppCompatActivity {
    private static final String TAG = ServiceLifecycleActivity.class.getSimpleName();

    private Intent intent;

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, ServiceLifecycleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_lifecycle_activity);

        setTitle(getString(R.string.service_lifecycle));

        intent = new Intent(ServiceLifecycleActivity.this, ExampleService.class);

        Button startServiceButton = (Button) findViewById(R.id.service_lifecycle_activity_start_service_button_id);
        Button stopServiceButton = (Button) findViewById(R.id.service_lifecycle_activity_stop_service_button_id);
        startServiceButton.setOnClickListener(startServiceOnClickListener);
        stopServiceButton.setOnClickListener(stopServiceOnClickListener);
    }

    private View.OnClickListener startServiceOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startService(intent);
        }
    };

    private View.OnClickListener stopServiceOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            stopService(intent);
        }
    };
}
