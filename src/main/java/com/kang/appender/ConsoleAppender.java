package com.kang.appender;

import com.kang.filters.Filter;
import com.kang.log4j.core.Layout;
import com.kang.log4j.core.LoggEvent;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @Author：zeqi
 * @Date: Created in 18:47 14/1/18.
 * @Description:
 */
public class ConsoleAppender implements Appender {

    private Writer  writer;
    @Override
    public void addFilter(Filter filter) {

    }

    @Override
    public void append(LoggEvent messageEvent) {
        try {
            writer.write(messageEvent.getMessage());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setLayout(Layout layout) {

    }


    public void activeOptions() {

        writer = new OutputStreamWriter(System.out);
    }
}
