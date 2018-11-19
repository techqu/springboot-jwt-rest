package com.quguang.springbootjwtdemo.common;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * fastjson 序列化过滤器,传入的属性将不被序列化
 */
public class MyPropertyPreFilter extends SimplePropertyPreFilter {
    private final Class<?> clazz;
    private final Set<String> includes;
    private final Set<String> excludes;
    private int maxLevel;

    public MyPropertyPreFilter(String... properties) {
        this((Class) null, properties);
    }

    public MyPropertyPreFilter(Class<?> clazz, String... properties) {
        this.includes = new HashSet<>();
        this.excludes = new HashSet<>();
        this.maxLevel = 0;
        this.clazz = clazz;
        String[] var3 = properties;
        int var4 = properties.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            String item = var3[var5];
            if (item != null) {
                this.excludes.add(item);
            }
        }

    }

    @Override
    public boolean apply(JSONSerializer serializer, Object source, String name) {
        if (source == null) {
            return true;
        } else if (this.clazz != null && !this.clazz.isInstance(source)) {
            return true;
        } else if (this.excludes.contains(name)) {
            return false;
        } else {
            return this.includes.size() == 0 || this.includes.contains(name);
        }
    }

}
