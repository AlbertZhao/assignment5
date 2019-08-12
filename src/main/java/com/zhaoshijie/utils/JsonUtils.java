package com.zhaoshijie.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhaoshijie.exceptions.JsonDeserializationException;
import com.zhaoshijie.exceptions.JsonSerializationException;

import java.io.IOException;

/**
 * JsonUtils class
 *
 * @author Zhao Shijie
 * @date 2019/08/12
 */
public class JsonUtils {

    private static final ObjectMapper OM = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return OM.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new JsonSerializationException(e);
        }
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        try {
            return OM.readValue(jsonString, clazz);
        } catch (IOException e) {
            throw new JsonDeserializationException(e, jsonString);
        }
    }

}
