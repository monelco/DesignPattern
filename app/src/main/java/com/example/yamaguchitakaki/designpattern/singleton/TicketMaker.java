package com.example.yamaguchitakaki.designpattern.singleton;

import android.util.Log;

public class TicketMaker {

    private static final String TAG = "TicketMaker";

    private static TicketMaker ticketMaker = new TicketMaker();

    private int ticket = 1000;

    private TicketMaker() {
        Log.d(TAG, "インスタンスを生成しました");
    }

    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    // getNextTicketNumberはsynchronizedメソッドにする
    // -> getNextTicketNumber()が複数のThreadから呼び出されても正常に動くようにするための措置
    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
