package converter;

import inputData.*;
import outputData.*;

public class UserConverter {

    public UserConverter() {
    }

    public OutputUsers convertUser(InputUsers users) {
        OutputUsers result = new OutputUsers();
        for (InputUser user : users.getUsers()) {
            result.addUser(new OutputUser(user.getFirstName() + ' ' + user.getLastName(), user.getId(), user.getLogin(), user.getPassword()));
        }
        return result;
    }
}
