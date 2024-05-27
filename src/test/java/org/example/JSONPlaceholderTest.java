package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONPlaceholderTest {

    @Test
    void testGetSinglePost() {
        // given
        String expected = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }";
        Post expectedPost = JSONMapper.convertJSON(expected);
        JSONPlaceholder jsonPlaceholder = new JSONPlaceholder();
        // when
        Post actual = jsonPlaceholder.getSinglePost(1);
        // then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedPost, actual);
    }

    @Test
    void testGetAllPosts() {
        // given
        JSONPlaceholder jsonPlaceholder = new JSONPlaceholder();
        int expectedSize = 100;
        // when
        List<Post> actual = jsonPlaceholder.getAllPosts();
        // then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedSize, actual.size());
    }

    @Test
    void testConversion() {
        // given
        String expected = "{\n  \"userID\" : 0,\n  \"id\" : 0,\n  \"title\" : null,\n  \"body\" : null\n}"
                .replaceAll("\n", "\r\n");
        Post post = new Post();
        // when
        String actual = JSONMapper.mapToJSON(post);
        // then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }
}