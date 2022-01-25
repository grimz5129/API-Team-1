package com.sparta.apiteam1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.apiteam1.pojo.ActorPOJO;
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

public class ActorEntityTests {
    @Test
    @DisplayName("GET request for actor_id = 220")
    public void getActor(){
        ObjectMapper mapper = new ObjectMapper();
        ActorPOJO actor;
        try {
            actor = mapper.readValue(new URL("http://localhost:8080/sakila/actor?id=220"), ActorPOJO.class);
            Assertions.assertEquals(220, actor.getId());
            Assertions.assertEquals("Yefri", actor.getFirstName());
            Assertions.assertEquals("Velasquez", actor.getLastName());
            Assertions.assertEquals("2021-12-08T15:25:47Z", actor.getLastUpdate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addNewActorHttpClientVersion() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest req = HttpRequest
                .newBuilder()
                .uri(new URI("http://localhost:8080/sakila/actor/add"))
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("actor.json")))
                .header("content-type", "application/json")
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> resp = client.send(req,
                HttpResponse.BodyHandlers.ofString());
        String json = resp.body();
        System.out.println(resp);
        ObjectMapper mapper = new ObjectMapper();
        ActorPOJO actor = mapper.readValue(json, ActorPOJO.class);
        System.out.println("Inserted New Actor with id = " + actor.getId());
        Assertions.assertEquals("Tester", actor.getFirstName());
        Assertions.assertEquals("Man", actor.getLastName());
        Assertions.assertEquals("2021-12-17T15:25:47Z", actor.getLastUpdate());
    }

    @Test
    public void updateActorHttpClientVersion() throws IOException, InterruptedException, URISyntaxException {
        int id = 2;
        String fName = "NICK";
        String lName = "WAHLBERG";
        String time = "2006-02-15T04:34:33Z";
        HttpRequest req = HttpRequest
                .newBuilder()
                .uri(new URI("http://localhost:8080/sakila/actor/update"))
                .PUT(HttpRequest.BodyPublishers.ofString("{\n" +
                        "    \"id\": 2,\n" +
                        "    \"firstName\": \"" + fName + "\",\n" +
                        "    \"lastName\": \"" + lName + "\",\n" +
                        "    \"lastUpdate\": \"" + time + "\"\n" +
                        "}"))
                .header("content-type", "application/json")
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> resp = client.send(req,
                HttpResponse.BodyHandlers.ofString());
        String json = resp.body();
        System.out.println(resp);
        ObjectMapper mapper = new ObjectMapper();
        ActorPOJO actor = mapper.readValue(json, ActorPOJO.class);
        System.out.println("Updated Actor with id = " + actor.getId());
        Assertions.assertEquals(fName, actor.getFirstName());
        Assertions.assertEquals(lName, actor.getLastName());
        Assertions.assertEquals(time, actor.getLastUpdate());
    }




}
