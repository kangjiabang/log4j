package com.kang.log4j.core;

/**
 * @Author：zeqi
 * @Date: Created in 21:13 8/1/18.
 * @Description:
 */
public interface Category {

    public void info(String message);

    public void debug(String message);

    public void warn(String message);

    public void error(String message);
}
