package com.kang.appender;

import com.kang.log4j.core.LoggEvent;

/**
 * @Author：zeqi
 * @Date: Created in 21:41 9/1/18.
 * @Description:
 */
public interface AppenderAttachable {

    public void  addAppender(Appender appender);

    public void  removeAppender(Appender appender);

    /**
     Get an appender by name.
     */
    public
    Appender getAppender(String name);

    void appendLoopOnAppenders(LoggEvent loggEvent);
}
