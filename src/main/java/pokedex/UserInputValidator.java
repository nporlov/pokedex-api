package pokedex;

import java.io.IOException;

public class UserInputValidator {
    public void validateUserCommand (String userCommand) throws IOException {
        if (userCommand == null)
            throw new NullPointerException("Command cannot be null");
        else if (userCommand.contains("/") ) {
            throw new IOException("Command should not contain /");
        }
    }
}
