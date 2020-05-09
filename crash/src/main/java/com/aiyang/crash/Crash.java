package com.aiyang.crash;

import android.content.Context;

import com.aiyang.crash.init.RealCrash;
import com.aiyang.crash.inter.ICrash;

public final class Crash {

    private static ICrash rCrash;


    public static void install(Context mContext,boolean isDebug) {
        //实例一次，安装一次
        if (rCrash==null){
            rCrash = new RealCrash(mContext,isDebug);
            rCrash.setUncaughtCrash();
        }
    }



}
