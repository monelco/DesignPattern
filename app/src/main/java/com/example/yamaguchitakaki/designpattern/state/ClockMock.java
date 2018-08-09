package com.example.yamaguchitakaki.designpattern.state;

import android.util.Log;

public class ClockMock {

    private static final String TAG = "ClockMock";

    private boolean mIsActive = true;

    public ClockMock() {
        Log.d(TAG, "DEBUG--:インスタンスを生成しました");
    }

    public void start(final StateContext stateContext) {
        mIsActive = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (mIsActive) {
                    for (int hour = 0; hour < 24; hour++) {
                        stateContext.setClock(hour);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Log.d(TAG, "DEBUG--:Catch InterruptedException");
                        }
                    }
                }
            }
        });

        thread.start();
    }

    public void stopClock() {
        mIsActive = false;
    }
}
