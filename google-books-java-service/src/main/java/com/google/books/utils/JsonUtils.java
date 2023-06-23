package com.google.books.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Tenzin Dawa
 */
@Slf4j
public final class JsonUtils {
    private JsonUtils() {
    }


    /**
     * @param objectToConvert
     * @return
     */
    public static String toString(Object objectToConvert) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            return objectMapper.writeValueAsString(objectToConvert);
        } catch (JsonProcessingException e) {
            log.error(e.getLocalizedMessage());
        }
        return new String();
    }

    /**
     *
     * @param jsonString
     * @param type
     * @return
     * @param <T>
     * @throws IOException
     */
    public static <T> T getObject(String jsonString, Class<T> type) throws IOException {
        final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return OBJECT_MAPPER.readValue(jsonString, type);
    }

    /**
     *
     * @param numberOfRecords
     * @return
     */
    public static String requestBodyJson(String numberOfRecords) {
        return "{\n" + "    \"size\": " + numberOfRecords + ",\n" + "    \"from\": 0,\n" + "    \"query\": {\n" + "        \"match_all\": {}\n" + "    }\n" + "}";
    }
}