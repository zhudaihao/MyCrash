package com.example.administrator.textcrash;

import android.app.Application;

import com.aiyang.crash.Crash;

public class MyAPP extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(){
            @Override
            public void run() {
                Crash.install(MyAPP.this,true);
            }
        }.start();

    }
}
