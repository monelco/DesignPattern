package com.example.yamaguchitakaki.designpattern.state;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yamaguchitakaki.designpattern.R;

public class SafeController implements StateContext, View.OnClickListener {

    private static final String TAG = "SafeController";

    private Activity mActivity;

    private State mState = DayState.getInstance();

    private ClockMock mClockMock = new ClockMock();

    private TextView mTextState;

    private TextView mTextHour;

    private String mHourStr;

    SafeController(Activity context) {
        mActivity = context;
    }

    public void onResume() {
        bindView();
        mClockMock.start(this);
    }

    private void bindView() {
        Button buttonUse = mActivity.findViewById(R.id.buttonUse);
        Button buttonAlarm = mActivity.findViewById(R.id.buttonAlarm);
        Button buttonPhone = mActivity.findViewById(R.id.buttonPhone);

        mTextHour = mActivity.findViewById(R.id.hour);
        mTextState = mActivity.findViewById(R.id.state);
        mTextState.setText(mState.toString());

        buttonUse.setOnClickListener(this);
        buttonAlarm.setOnClickListener(this);
        buttonPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonUse:
                mState.doUse(this);
                break;
            case R.id.buttonAlarm:
                mState.doAlaram(this);
                break;
            case R.id.buttonPhone:
                mState.doPhone(this);
                break;
            default:
        }
    }

    // 時刻の設定
    @Override
    public void setClock(int hour) {
        if (hour < 10) {
            mHourStr = "0" + hour + ":00";
        } else {
            mHourStr = hour + ":00";
        }

        // UI更新
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextHour.setText(mHourStr);
            }
        });
        mState.doClock(this, hour);
    }

    // 状態変化
    @Override
    public void changeState(State state) {
        Log.d(TAG, "DEBUG--:" + this.mState + "から" + state + "へ状態が変化しました");
        this.mState = state;

        // UI更新
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextState.setText(mState.toString());
            }
        });
    }

    // 警備センターの呼び出し
    @Override
    public void callSecurityCenter(String msg) {
        Log.d(TAG, "DEBUG--:call!" + msg);
    }

    // 警備センター記録
    @Override
    public void recordLog(String msg) {
        Log.d(TAG, "DEBUG--:record..." + msg);
    }

    public void onDestroy() {
        mClockMock.stopClock();
    }
}
