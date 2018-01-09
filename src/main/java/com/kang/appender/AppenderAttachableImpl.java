package com.kang.appender;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author：zeqi
 * @Date: Created in 21:50 9/1/18.
 * @Description:
 */
public class AppenderAttachableImpl implements  AppenderAttachable {



    private List<Appender> appenders = null;

    @Override
    public void addAppender(Appender appender) {
        if (appenders == null) {
            appenders = new LinkedList<Appender>();
        }
        appenders.add(appender);
    }

    @Override
    public void removeAppender(Appender appender) {

    }

    @Override
    public Appender getAppender(String name) {
        return null;
    }
}
