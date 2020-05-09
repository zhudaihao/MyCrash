package com.aiyang.crash.init;

import android.content.Context;
import android.os.Looper;

import com.aiyang.crash.R;
import com.aiyang.crash.inter.IKeepLoop;
import com.aiyang.crash.util.LogUtils;
import com.aiyang.crash.util.ToastUtil;

/**
 * @author aiyang
 */
public final class KeepLoop implements IKeepLoop {

    /**
     * 是否已轮询
     */
    private static boolean isWhile = true;

    private static KeepLoop mInstance;

    private static boolean isDebug;

    public static synchronized KeepLoop getInstance(boolean mIsDebug) {
        if (mInstance == null) {
            mInstance = new KeepLoop();
            isDebug = mIsDebug;
        }
        return mInstance;
    }

    /**
     * 主线程或子线程抛出异常后，迫使主线程Looper持续loop()
     */
    @Override
    public void keepLoop(final Context mContext, Thread t) {
        if (t == Looper.getMainLooper().getThread()) {
            if (isWhile) {
                isWhile = false;
                if (isDebug) {
                    ToastUtil.show(mContext, mContext.getString(R.string.crash_tip2));
                }
                while (true) {
                    try {
                        Looper.loop();
                    } catch (Throwable e) {
                        //再次出错，打印错误并提示，接着死循环，再次拉起loop
                        e.printStackTrace();
                        if (isDebug) {
                            ToastUtil.show(mContext, mContext.getString(R.string.crash_over));
                        }
                    }
                }
            }
        } else {
            if (isDebug) {
                LogUtils.d("zdh---",mContext.getString(R.string.crash_tip1));
            }
            new Thread() {
                @Override
                public void run() {
                    Looper.prepare();
                    if (isDebug) {
                        ToastUtil.show(mContext, mContext.getString(R.string.crash_tip1));
                    }
                    Looper.loop();
                }
            }.start();

        }
    }
}
