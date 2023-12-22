package com.bootsample.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


import org.apache.commons.lang3.StringUtils;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String toJson(Object obj) throws JsonGenerationException,
            JsonMappingException, IOException {
        StringWriter writer = new StringWriter();
        objectMapper.writeValue(writer, obj);
        return writer.toString();
    }

    public static <T> T toObject(Class<T> clazz, String requestJson,
                                 String callingMethod) throws IOException {
        T t = null;
        InputStream is = new ByteArrayInputStream(requestJson.getBytes(StandardCharsets.UTF_8));
        t = (T) objectMapper.readValue(is, clazz);
        return t;
    }

    public static <T> T toObject(String json, Class<T> className)
            throws JsonParseException, JsonMappingException, IOException {
        return toObject(className, json, "null");
    }

    public static <T> Object toObject(String json, TypeReference<T> typeRef)
            throws IOException {
        InputStream is = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
        return objectMapper.readValue(is, typeRef);
    }

    public static JsonNode convertObjectToJsonNode(Object object) {
        return objectMapper.valueToTree(object);
    }

    public static <T> Object getObjectFromFile(String fileName, Class<T> className)
            throws JsonParseException, JsonMappingException, IOException {
        T obj = null;
        File file = new File(fileName);
        obj = objectMapper.readValue(file, className);
        return obj;
    }

    public static JsonNode getJsonNodeFromQueryParamsMap(Map<String, String[]> queryParams) {
        if (queryParams == null) {
            return null;
        }
        Map<String, String> queryParamsMap = new HashMap<String, String>();

        for (Map.Entry<String, String[]> entry : queryParams.entrySet()) {

            queryParamsMap.put(entry.getKey(), entry.getValue()[0]);

        }
        return objectMapper.valueToTree(queryParamsMap);
    }

    public static JsonNode getFirstParamNodeFromQueryParams(Map<String, String[]> queryParams) {
        if (queryParams == null) {
            return null;
        }
        ObjectNode node = objectMapper.createObjectNode();
        for (String key : queryParams.keySet()) {
            node.put(key, queryParams.get(key)[0]);
        }
        return node;
    }

    public static <T> T getObjectFromJsonNode(JsonNode node, Class<T> className)
            throws JsonProcessingException {
        return objectMapper.treeToValue(node, className);
    }

    public static JsonNode getJsonNodeFromObject(Object object) {
        return objectMapper.valueToTree(object);
    }

    public static JsonNode getJsonNodeFromJsonString(String jsonString) throws JsonParseException,
            JsonMappingException, IOException {
        JsonNode retval = null;
        if (StringUtils.isNotEmpty(jsonString)) {
            retval = objectMapper.readValue(jsonString, JsonNode.class);
        }
        return retval;
    }

    public static ArrayNode createArrayNode() {
        return objectMapper.createArrayNode();
    }

    public static ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }

    public static List<String> getSortedArrayNode(ArrayNode arrayNode) throws IOException {
        List<String> list = new ArrayList<String>();
        for (JsonNode jsonNode : arrayNode) {
            list.add(jsonNode.asText());
        }
        Collections.sort(list);
        return list;
    }
}
