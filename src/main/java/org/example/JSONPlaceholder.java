package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JSONPlaceholder {
    private final String userURL = "https://jsonplaceholder.typicode.com/guide/";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getSinglePost(int id) {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder(new URI(userURL + "/" + id)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<List<String>> getAllPosts() {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder(new URI(userURL)).GET().build();

            HttpResponse<List<String>> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean HttpResponse<String> boolean addPost(String post) {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(userURL))
                    .POST(HttpRequest.BodyPublishers.ofString(java.lang.String.valueOf(post)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return true;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
