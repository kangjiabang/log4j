package com.kang.log4j.core;

import com.kang.utils.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：zeqi
 * @Date: Created in 21:44 8/1/18.
 * @Description:
 */
public class Level {



    private int priority;

    private String info;

    private static Map<String,Level> infoLevel = new HashMap<String,Level>();

    public Level(int priority,String info) {
        this.priority = priority;
        this.info = info;
    }

    public static final Level DEBUG = new Level(50,"DEBUG");

    public static final Level INFO = new Level(100,"INFO");

    public static final Level WARN = new Level(150,"WARN");

    public static final Level ERROR = new Level(200,"ERROR");

    static {
        infoLevel.put("DEBUG",DEBUG);
        infoLevel.put("INFO",INFO);
        infoLevel.put("WARN",WARN);
        infoLevel.put("ERROR",ERROR);
    }



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
        /*switch (info) {
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

        }*/
        Assert.hasText(info,"info can not be null");

        if (infoLevel.get(info.toUpperCase()) != null) {
            return infoLevel.get(info.toUpperCase());
        }
        return Level.INFO;
    }



    /**
     * 判断配置文件的配置是否含有常用日志级别
     */
    public static boolean hasLevel(String info) {
        Assert.hasText(info,"info can not be null");
        return infoLevel.containsKey(info.trim().toUpperCase());
    }


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
