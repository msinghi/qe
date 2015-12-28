package com.qe;

import java.util.concurrent.ThreadFactory;

import org.springframework.beans.factory.FactoryBean;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class QeThreadFactory implements FactoryBean<ThreadFactory> {

    private String threadNamePattern;

    private boolean daemon = true;

    @Override
    public ThreadFactory getObject() throws Exception {
        return new ThreadFactoryBuilder().setDaemon(daemon).setNameFormat(threadNamePattern).build();
    }   

    @Override
    public Class<ThreadFactory> getObjectType() {
        return ThreadFactory.class;
    }   

    @Override
    public boolean isSingleton() {
        return true;
    }   

    public void setThreadNamePattern(String threadNamePattern) {
        this.threadNamePattern = threadNamePattern;
    }   

    public void setDaemon(boolean daemon) {
        this.daemon = daemon;
    }   

}
