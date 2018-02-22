package com.kang.log4j.core;

/**
 * @Author：zeqi
 * @Date: Created in 17:37 11/2/18.
 * @Description:
 */
public class DefaultLogRepositorySelector implements  LogRepositorySelector {

    private  LogRepository repository;


    public DefaultLogRepositorySelector(LogRepository repository) {
        this.repository = repository;
    }

    public LogRepository getRepository() {
        return repository;
    }

    public void setRepository(LogRepository repository) {
        this.repository = repository;
    }
}
