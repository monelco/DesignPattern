package com.example.yamaguchitakaki.designpattern.state;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.yamaguchitakaki.designpattern.R;

public class SafeActivity extends AppCompatActivity {

    private SafeController mSafeController = new SafeController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);
    }

    @Override
    public void onResume() {
        super.onResume();
        mSafeController.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSafeController.onDestroy();
    }

}
