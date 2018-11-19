package com.quguang.springbootjwtdemo.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 瞿广 on 2018/11/17 0017.
 */
public class ReturnUtils {
    private ReturnUtils() {
    }

    public static String getSucJson(Object data) {
        Map<String, Object> map = new HashMap();
        map.put("ok", true);
        map.put("errorCode", "");
        map.put("errorMsg", "");
        map.put("data", data);
        return JSON.toJSONString(map, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
    }

    public static String getErrJson(Object data, BaseErrorType ecu) {
        Map<String, Object> map = new HashMap();
        map.put("ok", false);
        map.put("errorCode", ecu.getCode());
        map.put("errorMsg", ecu.getMessage());
        map.put("data", data);
        return JSON.toJSONString(map, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
    }

    public static String getErrJson(Object data, BaseErrorType ecu, String errMsg) {
        Map<String, Object> map = new HashMap();
        map.put("ok", false);
        map.put("errorCode", ecu.getCode());
        map.put("errorMsg", errMsg);
        map.put("data", data);
        return JSON.toJSONString(map, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
    }
}
