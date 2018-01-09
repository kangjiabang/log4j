package com.kang.helpers;

import com.kang.log4j.core.Hierarchy;
import com.kang.log4j.core.Logger;
import com.kang.log4j.core.RootLogger;
import com.kang.utils.Assert;

import java.util.Properties;

/**
 * @Author：zeqi
 * @Date: Created in 21:27 8/1/18.
 * @Description:
 */
public class ConfigurationParser {

    private Hierarchy h;

    private  static final String ROOT_CATEGORY = "log4j.rootCategory";


    public ConfigurationParser(Hierarchy h) {
        this.h = h;
    }

    /**
     * 解析配置文件
     * @param properties
     */
    public  void parse(Properties properties) {
        //获取配置文件中"log4j.rootCategory"的值
        String rootCategory = (String)properties.get(ROOT_CATEGORY);

        Assert.hasText(rootCategory,"log4j.rootCategory 配置不能为空");

        Logger root = h.getRoot();

    }
}
