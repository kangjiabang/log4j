package com.kang.manager;

import com.kang.loader.Loader;
import com.sun.tools.javac.util.Assert;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * @Author：zeqi
 * @Date: Created in 21:16 8/1/18.
 * @Description:
 */
@Slf4j
public class LogManager {

    private static final String DEFAULT_CONFIG_FILE_NAME = "log4j.properties";
    static {

        ClassLoader loader = Loader.getClassLoader();

        URL url = loader.getResource(DEFAULT_CONFIG_FILE_NAME);

        Assert.checkNonNull(url,"log4j.properties not in classpath.");

        Properties properties = new Properties();
        try {
            properties.load(url.openStream());
        } catch (IOException e) {
            log.error("load log4j.properties failed",e);
        }


    }
}
