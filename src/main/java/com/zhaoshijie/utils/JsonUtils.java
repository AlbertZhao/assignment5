package com.zhaoshijie.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhaoshijie.exceptions.JsonSerializationException;

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

}
