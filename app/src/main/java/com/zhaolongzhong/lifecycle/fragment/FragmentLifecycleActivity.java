package com.zhaolongzhong.lifecycle.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zhaolongzhong.lifecycle.R;

/**
 * Created by Zhaolong Zhong on 6/9/16.
 */
public class FragmentLifecycleActivity extends AppCompatActivity {
    private static final String TAG = FragmentLifecycleActivity.class.getSimpleName();

    private ExampleFragment fragment;

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, FragmentLifecycleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_lifecycle_activity);

        setTitle(getString(R.string.fragment_lifecycle));
        Button attachButton = (Button) findViewById(R.id.fragment_lifecycle_activity_attach_button_id);
        Button detachButton = (Button) findViewById(R.id.fragment_lifecycle_activity_detach_button_id);
        attachButton.setOnClickListener(attachOnClickListener);
        detachButton.setOnClickListener(detachOnClickListener);

        fragment = ExampleFragment.newInstance();
    }

    private View.OnClickListener attachOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "Attach button onClick");
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_lifecycle_activity_container_id, fragment).commit();
        }
    };

    private View.OnClickListener detachOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "Detach button onClick");
            getFragmentManager().beginTransaction().remove(fragment).commit();
        }
    };

    public static class ExampleFragment extends Fragment {
        private static final String TAG = ExampleFragment.class.getSimpleName();

        /**
         * Use this factory method to create a new instance of
         * this fragment
         */
        public static ExampleFragment newInstance() {
            return new ExampleFragment();
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            Log.d(TAG, "onAttach");
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            // This method is called after the Activity's onAttachFragment().
            // In this method, you can assign variables, get Intent extras, and anything else that
            // doesn't involve the View hierarchy.
            super.onCreate(savedInstanceState);
            Log.d(TAG, "onCreate");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(TAG, "onCreateView");
            return inflater.inflate(R.layout.example_fragment, container, false);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            // This method is called after the Activity's onCreate() has completed.
            // It is called after onCreateView(), and is mainly used for final initializations.
            super.onActivityCreated(savedInstanceState);
            Log.d(TAG, "onActivityCreated");
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.d(TAG, "onStart");
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.d(TAG, "onResume");
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.d(TAG, "onPause");
        }

        @Override
        public void onStop() {
            super.onStop();
            Log.d(TAG, "onStop");
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.d(TAG, "onDestroyView");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d(TAG, "onDestroy");
        }

        @Override
        public void onDetach() {
            super.onDetach();
            Log.d(TAG, "onDetach");
        }
    }
}
