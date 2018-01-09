package com.kang.log4j.core;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：zeqi
 * @Date: Created in 21:28 9/1/18.
 * @Description:
 */
public class Hierarchy {

    private Logger  root;

    private Map<String,Logger> loggerHashMap = new HashMap<String,Logger>();

    private LoggerFactory loggerFactory;

    public Hierarchy(Logger rootLogger) {
        this.root = rootLogger;
    }

    public Logger getRoot() {
        return root;
    }

    public void setRoot(Logger root) {
        this.root = root;
    }
}
