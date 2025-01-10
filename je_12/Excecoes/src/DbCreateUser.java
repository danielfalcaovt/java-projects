import java.util.regex.Pattern;

public class DbCreateUser {
    public User create(String name) throws PersonalizedException, OtherException {
        if (name.isEmpty()) {
            throw new PersonalizedException();
        }
        if (name.matches(".*[^a-zA-Z].*")) {
            throw new OtherException();
        }
        return new User(name);
    }

    ;
}
