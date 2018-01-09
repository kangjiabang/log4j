package com.kang.appender;

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
}
