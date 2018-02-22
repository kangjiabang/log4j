package com.kang.helpers;

import com.kang.appender.Appender;
import com.kang.loader.LoaderFactory;
import com.kang.log4j.core.Hierarchy;
import com.kang.log4j.core.Level;
import com.kang.log4j.core.Logger;
import com.kang.log4j.core.RootLogger;
import com.kang.utils.Assert;
import com.kang.utils.ClassUtils;
import com.kang.utils.LogLog;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * @Author：zeqi
 * @Date: Created in 21:27 8/1/18.
 * @Description:
 */
public class PropertiesConfigurator {

    private Hierarchy h;

    private  static final String ROOT_CATEGORY = "log4j.rootCategory";

    private static final String APPENDER_PREFIX = "log4j.appender";


    public PropertiesConfigurator(Hierarchy h) {
        this.h = h;
    }

    /**
     * 解析配置文件
     * @param properties
     */
    public  void parse(Properties properties) {
        //解析RootLogger
        parseRootCategory(properties);


    }

    private void parseRootCategory(Properties properties) {
        //获取配置文件中"log4j.rootCategory"的值
        String rootCategory = (String)properties.get(ROOT_CATEGORY);

        Assert.hasText(rootCategory,"log4j.rootCategory 配置不能为空");

        Logger root = h.getRoot();

        //获取日志级别
        StringTokenizer tokenizer = new StringTokenizer(rootCategory,",");
        if (!tokenizer.hasMoreTokens()) {
            return;
        }
        //获取日志级别
        String logLevel = tokenizer.nextToken();
        if (!StringUtils.isEmpty(logLevel) && Level.hasLevel(logLevel)) {
            root.setLevel(Level.toLevel(logLevel));
        }
        //设置Appenders
        while (tokenizer.hasMoreTokens()) {

            String appenderName = tokenizer.nextToken().trim();
            if (StringUtils.isEmpty(appenderName)) {
                continue;
            }
            LogLog.debug("begin to parse appender \"" +appenderName + "\".");
            //parseAppender()
            Appender appender = parseAppender(properties, appenderName.trim());

            root.addAppender(appender);

        }
    }

    /**
     * 获取appender
     * @param properties
     * @param appenderName
     */
    private Appender parseAppender(Properties properties, String appenderName) {

        try {
            //获取appender配置的类名
            String appenderClassName = (String)properties.get(APPENDER_PREFIX + "." + appenderName);

            if (StringUtils.isEmpty(appenderClassName)) {
                LogLog.error("cannot find value for key " + appenderName);
                return null;
            }
            Appender appender = (Appender) ClassUtils.instantiateByName(appenderClassName.trim(),Appender.class,
                    null);

            Method activeOptionsMethod = appender.getClass().getDeclaredMethod("activeOptions",null);
            activeOptionsMethod.invoke(appender);
            //调用appender的activeOptions方法
            return appender;
        } catch (NoSuchMethodException e) {
            LogLog.error("no such method exception." ,e);
        } catch (IllegalAccessException e) {
            LogLog.error("IllegalAccessException exception." ,e);
        } catch (InvocationTargetException e) {
            LogLog.error("InvocationTargetException exception." ,e);
        }
        return null;
    }
}
