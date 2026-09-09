package org.example;

import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    static void main(String[] args) {
        String command = null;
        String url = null;

        // CHECK FOR EMPTY INPUT
        try {
            command = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("No command entered. " + e);
        }
        try {
            url = args[1];
        }  catch (IndexOutOfBoundsException e) {
            System.err.println("No URL entered. " + e);
        }

        try {
            switch (command) {
                case "get": {
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .build();
                    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
                    ObjectMapper mapper = new ObjectMapper();
                    Pokemon pokemon = mapper.readValue(response.body(), Pokemon.class);
                    pokemon.printBasicInfo();
                    break;
                }
                default: System.out.println("Unknown command: " + command);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending request.");
        }
    }
}