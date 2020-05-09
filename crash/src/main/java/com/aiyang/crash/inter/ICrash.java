package com.aiyang.crash.inter;

public interface ICrash {

    /**
     * 拦截异常捕获
     */
    void setUncaughtCrash();
    /**
     * 错误处理检测
     * @return true:可以处理该异常; 否则返回false
     */
    boolean handleException(Throwable ex);

}
