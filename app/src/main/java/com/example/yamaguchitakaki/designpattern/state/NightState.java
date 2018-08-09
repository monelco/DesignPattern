package com.example.yamaguchitakaki.designpattern.state;

import android.util.Log;

import javax.xml.transform.sax.SAXTransformerFactory;

public class NightState implements State {

    private static final String TAG = "NightState";

    private static NightState nightState = new NightState();

    private NightState() {
        Log.d(TAG, "DEBUG--:インスタンスを生成しました");
    }

    public static State getInstance() {
        return nightState;
    }

    @Override
    public void doClock(StateContext stateContext, int hour) {
        if (9 <= hour && hour < 17) {
            stateContext.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(StateContext stateContext) {
        stateContext.callSecurityCenter("非常：夜間の金庫使用!");
    }

    @Override
    public void doAlaram(StateContext stateContext) {
        stateContext.callSecurityCenter("非常ベル(夜間)");
    }

    @Override
    public void doPhone(StateContext stateContext) {
        stateContext.recordLog("夜間の通話録音");
    }

    @Override
    public String toString() {
        return "[夜間]";
    }
}
