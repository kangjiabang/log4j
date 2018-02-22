package com.kang.log4j.core;

/**
 * @Author：zeqi
 * @Date: Created in 17:37 11/2/18.
 * @Description:
 */
public interface LogRepositorySelector {

     LogRepository getRepository();

     void setRepository(LogRepository repository);
}
