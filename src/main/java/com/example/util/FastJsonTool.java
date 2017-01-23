package com.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * FastJsonTool
 *
 * @author YuanJingtao
 * @version 1.0
 * @date 2017-01-23 15:42
 */
public class FastJsonTool {

    private FastJsonTool() {

    }

    public static <T> String serializeWithClz(T object) {
        return JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteClassName);
    }

    public static <T> T deserializeWithClz(String jsonStr) {
        return (T) JSON.parseObject(jsonStr, Object.class);
    }

    public static <T> String serialize(T object) {
        return JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
    }

    public static <T> T deserialize(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }


}
