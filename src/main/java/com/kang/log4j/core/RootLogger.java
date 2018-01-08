package com.kang.log4j.core;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author：zeqi
 * @Date: Created in 21:42 8/1/18.
 * @Description:
 */
public class RootLogger  implements  Category  {


    private List<Appender>  appenders = new LinkedList<Appender>();

    public void info(String message) {


    }

    public void debug(String message) {

    }

    public void warn(String message) {

    }

    public void error(String message) {

    }
}
