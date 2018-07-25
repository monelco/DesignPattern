package com.example.yamaguchitakaki.designpattern.state;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.yamaguchitakaki.designpattern.R;

public class SafeController implements StateContext, View.OnClickListener {

    private static final String TAG = "SafeController";

    private Activity mActivity;

    private State mState = DayState.getInstance();

    private TestSafe mTestSafe = TestSafe.getInstance();

    SafeController(Activity context) {
        mActivity = context;
        mTestSafe.start(this);
    }

    public void onResume() {
        bindView();
    }

    private void bindView() {
        Button buttonUse = mActivity.findViewById(R.id.buttonUse);
        Button buttonAlarm = mActivity.findViewById(R.id.buttonAlarm);
        Button buttonPhone = mActivity.findViewById(R.id.buttonPhone);

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
        String clockString = "現在時刻は";
        if (hour < 10) {
            clockString += "0" + hour + ":00";
        } else {
            clockString += hour + ":00";
        }
        Log.d(TAG, "DEBUG--:clockString->" + clockString);
        mState.doClock(this, hour);
    }

    // 状態変化
    @Override
    public void changeState(State state) {
        Log.d(TAG, "DEBUG--:" + this.mState + "から" + state + "へ状態が変化しました");
        this.mState = state;
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
        mTestSafe.stopClock();
    }
}
