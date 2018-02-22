package com.kang.utils;

import org.springframework.util.StringUtils;

/**
 * @Author：zeqi
 * @Date: Created in 17:50 14/1/18.
 * @Description:
 */
public class LogLog {

    //是否设置为静态模式
    private  static boolean quietMode = false;

    //debug 模式是否开启
    private  static boolean isDebugEnabled = false;

    public static final String DEBUG_KEY="log4j.debug";

    private  static final String PREFIX = "log4j: ";
    private  static final String WARN_PREFIX = "log4j:warn ";
    private  static final String ERR_PREFIX = "log4j:Error ";

    static {
        String value = System.getProperty(DEBUG_KEY,null);
        isDebugEnabled = toBoolean(value,true);
    }

    public static boolean toBoolean(String value,boolean dEfault) {
        if (StringUtils.isEmpty(value)) {
            return dEfault;
        }
        if (value.equalsIgnoreCase("true")) {
            return true;
        }
        if (value.equalsIgnoreCase("false")) {
            return false;
        }

        return dEfault;
    }
    /**
     * 最底层日志打印逻辑
     * @param message
     */
    public static void info(String message) {
        if (quietMode)
            return;
        Assert.hasText(message,"message can not be NULL");
        System.out.println(PREFIX + message);
    }

    /**
     * 最底层日志打印逻辑
     * @param message
     */
    public static void warn(String message) {
        if (quietMode)
            return;
        Assert.hasText(message,"message can not be NULL");
        System.out.println(WARN_PREFIX + message);
    }

    /**
     * 最底层日志打印逻辑
     * @param message
     */
    public static void debug(String message) {
        Assert.hasText(message,"message can not be NULL");
        if (isDebugEnabled && !quietMode) {
            System.out.println(PREFIX + message);
        }

    }

    /**
     * 最底层日志打印逻辑
     * @param message
     */
    public static void debug(String message,Throwable t) {
        Assert.hasText(message,"message can not be NULL");
        if (isDebugEnabled && !quietMode) {
            System.out.println(PREFIX + message);
            if (t != null) {
                t.printStackTrace();
            }
        }

    }

    /**
     * 最底层日志打印逻辑
     * @param message
     */
    public static void error(String message) {
        if (quietMode)
            return;
        Assert.hasText(message,"message can not be NULL");
        System.err.println(ERR_PREFIX + message);
    }
    /**
     * 最底层日志打印逻辑
     * @param message
     */
    public static void error(String message,Throwable t) {
        if (quietMode)
            return;
        Assert.hasText(message,"message can not be NULL");
        System.err.println(ERR_PREFIX + message);
        if (t != null) {
            t.printStackTrace();
        }
    }

    public static void setQuietMode(boolean quietMode) {
        LogLog.quietMode = quietMode;
    }
}
