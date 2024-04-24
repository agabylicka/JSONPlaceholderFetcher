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
        System.out.println(jsonPlaceholder.getSinglePost(1));
        //HttpResponse<String> response = jsonPlaceholder.getSinglePost(1);
        //System.out.println(response.statusCode());
        //System.out.println(response.body());
        //System.out.println(response.headers());

        JSONPlaceholder post = new JSONPlaceholder();
        boolean response = post.addPost("{\n" +
               " \"id\": 1,\n" +
                "}"
        );
    }
}