package com.example.yamaguchitakaki.designpattern.singleton;

import android.util.Log;

public class Triple {

    private static final String TAG = "Triple";

    // ダメな例（自分で最初に書いたやつ、、、)
//    private static Triple triple1 = new Triple();
//
//    private static Triple triple2 = new Triple();
//
//    private static Triple triple3 = new Triple();
//
//    private Triple(){
//        Log.d(TAG, "インスタンスを生成しました");
//    }
//
//    public static Triple getInstance(int id) {
//        switch (id) {
//            case 1:
//                return triple1;
//            case 2:
//                return triple2;
//            case 3:
//                return triple3;
//            default:
//                return triple1;
//        }
//    }

    // 良い例
    private static Triple[] triples = new Triple[] {
            new Triple(0),
            new Triple(1),
            new Triple(2)
    };

    private int id;

    private Triple(int id) {
        Log.d(TAG, "DEBUG--:インスタンスを生成しました");
        this.id = id;
    }

    public static Triple getInstance(int id) {
        return triples[id];
    }

}
