package com.kang.log4j.core;

/**
 * @Author：zeqi
 * @Date: Created in 21:44 8/1/18.
 * @Description:
 */
public class Level {

    private int priority;

    private String info;

    public Level(int priority,String info) {
        this.priority = priority;
        this.info = info;
    }


    public static final Level DEBUG = new Level(50,"DEBUG");

    public static final Level INFO = new Level(100,"INFO");

    public static final Level WARN = new Level(150,"WARN");

    public static final Level ERROR = new Level(200,"ERROR");

    public boolean isGreaterOrEquals(Level level) {
        return this.priority >= level.priority;
    }

    /**
     * 根据配置获取日志级别
     * @param info
     * @return
     */
    public static Level toLevel(String info) {
        Level level = null;
        switch (info) {
            case "DEBUG":
                level =  Level.DEBUG;
                break;
            case "INFO":
                level =  Level.INFO;
                break;
            case "WARN":
                level =  Level.WARN;
                break;
            case "ERROR":
                level =  Level.ERROR;
                break;
            default:
                level = Level.INFO;

        }
        return level;
    }

}
