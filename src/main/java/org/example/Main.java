//2. Po zapoznaniu się możliwościami REST API (jakie możliwe są zapytania, operacje, odpowiedzi, kody odpowiedzi), stwórz
// klasę JSONPlaceholderFetcher, która będzie zawierać w sobie 3 metody do obsługi tego API:
//a. public String getSinglePost(int id) -> używając metody GET, zapytaj o pojedynczy post, używając podanego id przy
//budowie URI i zwróć ten post;
//b. public String getAllPosts() -> używając metody GET zapytaj o wszystkie posty i zwróć je;
//c. public boolean addPost(String post) -> dodaj ciało do swojego zapytania a następnie używając metody POST dodaj nowe
//dane do istniejącego zasobu. Zwróć true, kiedy operacja zakończy się sukcesem, false, jeśli nie (oprzyj sie o zwrócony kod).

package org.example;

import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        JSONPlaceholder jsonPlaceholder = new JSONPlaceholder();
        //HttpResponse<String> response = jsonPlaceholder.getSinglePost(1);
        //System.out.println(response.statusCode());
        //System.out.println(response.body());
        //System.out.println(response.headers());

        JSONPlaceholder jsonPlaceholder1 = new JSONPlaceholder();
        System.out.println(jsonPlaceholder1.getAllPosts());


        JSONPlaceholder post = new JSONPlaceholder();
        String requestBody = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}\n";
        boolean answer = post.addPost(requestBody);
        System.out.println(answer);

        Post response = jsonPlaceholder.getSinglePost(1);

        System.out.println(response);

        String json = JSONMapper.mapToJSON(response);
        System.out.println(json);
    }
}

