package com.kang.log4j.core;

import com.kang.appender.Appender;
import com.kang.appender.AppenderAttachable;
import com.kang.appender.AppenderAttachableImpl;

/**
 * @Author：zeqi
 * @Date: Created in 21:13 8/1/18.
 * @Description:
 */
public class Category implements AppenderAttachable {


    private String name;

    private volatile  Level level;

    private AppenderAttachable aai = null;


    public Category(String name) {
        this.name = name;
    }
    public void info(String message) {

    }

    public void debug(String message) {

    }

    public void warn(String message) {

    }

    public void error(String message) {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public void addAppender(Appender appender) {
        synchronized (this) {
            if (aai == null) {
                aai = new AppenderAttachableImpl();
            }
            aai.addAppender(appender);
        }

    }

    @Override
    public void removeAppender(Appender appender) {

    }

    @Override
    public Appender getAppender(String name) {
        return null;
    }
}
