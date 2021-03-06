package com.gionee.common.utils;

import java.lang.reflect.Type;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 */
public class JsonUtils {

    /**
     * 将一个{@link Object}转成{@code Json}格式的{@link String}
     * 
     * @param object 需要转换的数据
     * @return 返回{@code Json}格式的{@link String}
     * @throws Exception 抛出异常
     */
    public static <T> String writeObject2Json(T object) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    /**
     * 将{@code Json}格式的{@link String}转换成一个{@link Class}{@code <T>}类型的实例
     * 
     * @param json {@code Json}格式的{@link String}
     * @param clazz 需要转换成的实例类型
     * @return 返回{@link Type}类型的实例
     * @throws Exception 抛出异常
     */
    public static <T> T readJson2Object(String json, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, clazz);
    }

}
