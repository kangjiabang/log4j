package com.kang.utils;

import com.kang.appender.Appender;
import com.kang.loader.LoaderFactory;

/**
 * @Author：zeqi
 * @Date: Created in 18:14 14/1/18.
 * @Description:
 */
public class ClassUtils {

    /**
     * 实例化类
     * @param className
     * @param superType
     * @return
     */
    public static Object instantiateByName(String className,Class<?> superType,Object defaultObject) {

        ClassLoader loader = LoaderFactory.getClassLoader();
        try {
            Class<?> clazz = loader.loadClass(className);

            if (!superType.isAssignableFrom(clazz)) {
                LogLog.error(String.format("className(%s) is not subClass of (%s)",className,superType.getName()));
                return defaultObject;
            }
            return  clazz.newInstance();
        }
        catch (ClassNotFoundException e) {
            LogLog.error("加载类失败，className：" + className,e);
        } catch (InstantiationException e) {
            LogLog.error("实例化类失败，className：" + className,e);
        } catch (IllegalAccessException e) {
            LogLog.error("实例化类失败，className：" + className,e);
        } catch (Exception e) {
            LogLog.error("实例化类失败，className：" + className,e);
        }
        return defaultObject;
    }
}
