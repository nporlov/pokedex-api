package pokedex;

import tools.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;

public class DependencyContainer {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static HttpClient getHttpClient() {
        return client;
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }
}
