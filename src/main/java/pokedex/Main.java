package pokedex;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    static void main(String[] args) {
        String command = null;
        String parameter = null;

        // CHECK FOR EMPTY INPUT
        try {
            command = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("No command entered.");
        }
        try {
            parameter = args[1];
        }  catch (IndexOutOfBoundsException e) {
            System.err.println("No name or id entered.");
        }

        // CHECK FOR VALID COMMAND
        try {
            DependencyContainer.getInputValidator().validateUserCommand(command);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(Properties.url + command + "/" + parameter))
                    .build();
            HttpResponse<String> response = DependencyContainer.getHttpClient()
                    .send(request, BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                switch (command) {
                    case "pokemon": {
                        Pokemon pokemon = DependencyContainer.getObjectMapper()
                                .readValue(response.body(), Pokemon.class);
                        pokemon.printBasicInfo();
                        break;
                    }
                    case "ability": {
                        Ability ability;
                        ability = DependencyContainer.getObjectMapper()
                                .readValue(response.body(), Ability.class);
                        ability.printBasicInfo();
                        break;
                    }
                    default: System.out.println("Unknown command: " + command);
                }
            }
            else {
                System.err.println("Server responded with error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending request.");
        }
    }
}