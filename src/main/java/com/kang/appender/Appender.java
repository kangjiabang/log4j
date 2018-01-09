package com.kang.appender;

import com.kang.filters.Filter;
import com.kang.log4j.core.Layout;

/**
 * @Author：zeqi
 * @Date: Created in 21:44 8/1/18.
 * @Description:
 */
public interface Appender {

     void addFilter(Filter filter);

     void append(String message);

     void setLayout(Layout layout);
}
