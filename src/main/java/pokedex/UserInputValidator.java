package pokedex;

import java.io.IOException;

public class UserInputValidator {
    public void validateUserCommand (String userCommand) throws IOException {
        if (userCommand.contains("/") ) {
            throw new IOException("Command should not contain /");
        }
    }
}
