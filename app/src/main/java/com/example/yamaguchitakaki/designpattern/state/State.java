package com.example.yamaguchitakaki.designpattern.state;

public interface State {
    abstract void doClock(StateContext stateContext, int hour); // 時刻設定
    abstract void doUse(StateContext stateContext); // 金庫使用
    abstract void doAlaram(StateContext stateContext); // 非常ベル
    abstract void doPhone(StateContext stateContext); // 通常通話
}
