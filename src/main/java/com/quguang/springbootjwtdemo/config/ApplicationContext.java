package com.quguang.springbootjwtdemo.config;

import com.google.common.collect.Maps;

import java.util.Map;

public class ApplicationContext {
    static Map<Class<?>,Object> beanMap = Maps.newConcurrentMap();

    public static <T> T getBean(Class<T> requireType){
        return (T) beanMap.get(requireType);
    }

    public static void registerBean(Object item){
        beanMap.put(item.getClass(),item);
    }
}
