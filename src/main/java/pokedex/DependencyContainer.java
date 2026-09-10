package pokedex;

import tools.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;

public class DependencyContainer {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final UserInputValidator validator = new UserInputValidator();

    public static HttpClient getHttpClient() {
        return client;
    }
    public static ObjectMapper getObjectMapper() {
        return mapper;
    }
    public static UserInputValidator getInputValidator() {return  validator;}
}
