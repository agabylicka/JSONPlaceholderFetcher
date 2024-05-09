package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    public static Post convertJSON(String postJSON) {
        Post post = new Post();
        try {
            JsonNode node = MAPPER.readTree(postJSON);
            post.setUserID(Integer.parseInt(node.get("userId").asText()));
            post.setTitle((node.get("title").textValue()));
            post.setBody((node.get("body").textValue()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return post;

    }

}
