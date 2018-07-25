package com.example.yamaguchitakaki.designpattern.singleton;

import android.util.Log;

public class Singleton {

    private static final String TAG = "Singleton";

    // staticなフィールドはクラスに初めてアクセスされた時に一度だけ初期化される
    private static Singleton singleton = new Singleton();

    private Singleton() {
        Log.d(TAG, "DEBUG--:インスタンスを生成しました");
    }

    public static Singleton getInstance() {
        return  singleton;
    }
}
