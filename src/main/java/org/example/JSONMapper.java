package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    public static Post convertJSON(String postJSON) {
        Post post = new Post();
        try {
            JsonNode node = MAPPER.readTree(postJSON);
            post.setUserID(Integer.parseInt(node.get("UserID").textValue()));
            post.setTitle((node.get("Title").textValue()));
            post.setBody((node.get("Body").textValue()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return post;
    }

}