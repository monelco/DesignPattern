package com.example.yamaguchitakaki.designpattern.singleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yamaguchitakaki.designpattern.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Singleton singleton1 = Singleton.getInstance();
//        Singleton singleton2 = Singleton.getInstance();
//
//        if (singleton1 == singleton2) {
//            Log.d(TAG, "DEBUG--:singleton1とsingleton2は同一のインスタンス");
//        }

        TicketMaker ticketMaker = TicketMaker.getInstance();
        TicketMaker ticketMaker1 = TicketMaker.getInstance();

        Log.d(TAG, "DEBUG--:ticket->" + ticketMaker.getNextTicketNumber());
        Log.d(TAG, "DEBUG--:ticket->" + ticketMaker1.getNextTicketNumber());
        Log.d(TAG, "DEBUG--:ticket->" + ticketMaker.getNextTicketNumber());
        Log.d(TAG, "DEBUG--:ticket->" + ticketMaker.getNextTicketNumber());
        Log.d(TAG, "DEBUG--:ticket->" + ticketMaker1.getNextTicketNumber());


    }
}
