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
        String parameter = null;
        String url = "https://pokeapi.co/api/v2/";

        // CHECK FOR EMPTY INPUT
        try {
            command = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("No command entered. " + e);
        }
        try {
            parameter = args[1];
        }  catch (IndexOutOfBoundsException e) {
            System.err.println("No name or id entered. " + e);
        }

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + command + "/" + parameter))
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            switch (command) {
                case "pokemon": {
                    Pokemon pokemon;
                    pokemon = mapper.readValue(response.body(), Pokemon.class);
                    pokemon.printBasicInfo();
                    break;
                }
                case "ability": {
                    Ability ability;
                    ability = mapper.readValue(response.body(), Ability.class);
                    ability.printBasicInfo();
                    break;
                }
                default: System.out.println("Unknown command: " + command);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending request.");
        }
    }
}