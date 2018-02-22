package com.kang.log4j.core;

import com.kang.appender.Appender;
import com.kang.appender.AppenderAttachable;
import com.kang.appender.AppenderAttachableImpl;

/**
 * @Author：zeqi
 * @Date: Created in 21:13 8/1/18.
 * @Description:
 */
public class Category {


    private String name;

    private volatile  Level level;

    protected Category parent;

    private AppenderAttachable aai = null;

    private String categoryName = Category.class.getName();


    public Category(String name) {
        this.name = name;
    }
    public void info(String message) {
        //TO Replace this.level
        if (Level.INFO.isGreaterOrEquals(this.level)) {
            forceLog(new LoggEvent(message,categoryName));
        }
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


    public void addAppender(Appender appender) {
        synchronized (this) {
            if (aai == null) {
                aai = new AppenderAttachableImpl();
            }
            aai.addAppender(appender);
        }

    }

    public void removeAppender(Appender appender) {

    }


    public Appender getAppender(String name) {
        return null;
    }


    private void forceLog(LoggEvent loggEvent) {
        callAppenders(loggEvent);
    }

    private void callAppenders(LoggEvent loggEvent) {
        for (Category c=this; c != null; c = c.parent) {
            c.aai.appendLoopOnAppenders(loggEvent);
        }
    }
}
