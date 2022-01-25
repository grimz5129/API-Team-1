package com.sparta.apiteam1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiteam1.pojo.FilmPOJO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class FilmEntityTests {
    @Test
    @DisplayName("GET request for film_id = 1")
    public void getFilm(){
        ObjectMapper mapper = new ObjectMapper();
        FilmPOJO film;
        try {
            film = mapper.readValue(new URL("http://localhost:8080/sakila/film?id=1"), FilmPOJO.class);
            Assertions.assertEquals(1, film.getId());
            Assertions.assertEquals("ACADEMY DINOSAUR", film.getTitle());
            Assertions.assertEquals("A Epic Drama of a Feminist And a Mad Scientist who " +
                    "must Battle a Teacher in The Canadian Rockies", film.getDescription());
            Assertions.assertEquals("PG", film.getRating());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addNewFilmHttpClientVersion() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest req = HttpRequest
                .newBuilder()
                .uri(new URI("http://localhost:8080/sakila/film/add"))
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("film.json")))
                .header("content-type", "application/json")
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> resp = client.send(req,
                HttpResponse.BodyHandlers.ofString());
        String json = resp.body();
        System.out.println(resp);
        ObjectMapper mapper = new ObjectMapper();
        FilmPOJO film = mapper.readValue(json, FilmPOJO.class);
        System.out.println("Inserted New Film with id = " + film.getId());
        Assertions.assertEquals("TEAM ONE", film.getTitle());
        Assertions.assertEquals("An Epic Development Team - " +
                "Yefri, Kamil, George, Jakub, Ishmael", film.getDescription());
        Assertions.assertEquals("2021-12-15T05:03:42Z", film.getLastUpdate());
    }


}
