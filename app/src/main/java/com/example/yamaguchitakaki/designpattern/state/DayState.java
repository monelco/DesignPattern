package com.example.yamaguchitakaki.designpattern.state;

import android.util.Log;

public class DayState implements State {

    private static DayState dayState = new DayState();

    private DayState(){
    }

    public static State getInstance() {
        return dayState;
    }

    @Override
    public void doClock(StateContext stateContext, int hour) {
        if (hour < 9 || 17 <= hour) {
            stateContext.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(StateContext stateContext) {
        stateContext.recordLog("金庫使用(昼間)");
    }

    @Override
    public void doAlaram(StateContext stateContext) {
        stateContext.callSecurityCenter("非常ベル(昼間)");
    }

    @Override
    public void doPhone(StateContext stateContext) {
        stateContext.callSecurityCenter("通常の通話(昼間)");
    }

    @Override
    public String toString() {
        return "[昼間]";
    }
}
