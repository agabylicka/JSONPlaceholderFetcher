package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JSONPlaceholder {
    private final String userURL = "https://jsonplaceholder.typicode.com/posts";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getSinglePost(int id) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(userURL + "/" + id)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> getAllPosts() {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(userURL)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addPost(String post) {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(userURL))
                    .POST(HttpRequest.BodyPublishers.ofString(java.lang.String.valueOf(post)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int response2 = response.statusCode();
            if (response2 == 201) {
                return true;
            } else
                return false;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

