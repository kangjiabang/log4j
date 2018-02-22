package com.kang.test;

import com.kang.appender.Appender;
import com.kang.appender.ConsoleAppender;
import com.kang.log4j.core.Category;
import com.kang.log4j.core.LoggEvent;
import com.kang.log4j.core.Logger;
import org.junit.Test;

/**
 * @Author：zeqi
 * @Date: Created in 17:17 11/2/18.
 * @Description:
 */
public class AppenderTest {

    @Test
    public void testAppenderWrite() {
        Appender appender = new ConsoleAppender();

        appender.activeOptions();
        appender.append(new LoggEvent("hello appender",Category.class.getName()));
    }
}
