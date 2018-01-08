package com.kang.loader;

import sun.reflect.Reflection;

/**
 * @Author：zeqi
 * @Date: Created in 21:15 8/1/18.
 * @Description:
 */
public class Loader {

    /**
     * 获取加载器
     * @return
     */
    public static ClassLoader getClassLoader() {

        //获取上下文类加载器
       ClassLoader contextClassLoader =  Thread.currentThread().getContextClassLoader();

       if (contextClassLoader == null) {
           //获取调用类的classLoader
           ClassLoader callerClassLoader  =  Reflection.getCallerClass().getClassLoader();

           //获取系统类加载器
           if (callerClassLoader == null) {
               return  ClassLoader.getSystemClassLoader();
           }
           return callerClassLoader;
       }

       return contextClassLoader;
    }
}
