package com.zhaolongzhong.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhaolongzhong.lifecycle.activity.ActivityLifecycleActivity;
import com.zhaolongzhong.lifecycle.fragment.FragmentLifecycleActivity;
import com.zhaolongzhong.lifecycle.service.ServiceLifecycleActivity;

/**
 * Created by Zhaolong Zhong on 6/9/16.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        TextView activityTextView = (TextView) findViewById(R.id.main_activity_activity_lifecycle_text_view_id);
        TextView fragmentTextView = (TextView) findViewById(R.id.main_activity_fragment_lifecycle_text_view_id);
        TextView serviceTextView = (TextView) findViewById(R.id.main_activity_service_lifecycle_text_view_id);

        activityTextView.setOnClickListener(activityOnClickListener);
        fragmentTextView.setOnClickListener(fragmentOnClickListener);
        serviceTextView.setOnClickListener(serviceOnClickListener);
    }

    private View.OnClickListener activityOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ActivityLifecycleActivity.newInstance(MainActivity.this);
        }
    };

    private View.OnClickListener fragmentOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentLifecycleActivity.newInstance(MainActivity.this);
        }
    };

    private View.OnClickListener serviceOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ServiceLifecycleActivity.newInstance(MainActivity.this);
        }
    };
}
