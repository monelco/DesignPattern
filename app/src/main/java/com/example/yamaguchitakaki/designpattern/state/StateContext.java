package com.example.yamaguchitakaki.designpattern.state;

public interface StateContext {
    abstract void setClock(int hour);  // 時刻の設定
    abstract void changeState(State state); // 状態変化
    abstract void callSecurityCenter(String msg); // 警備センター呼び出し
    abstract void recordLog(String msg); // 警備センター記録
}
