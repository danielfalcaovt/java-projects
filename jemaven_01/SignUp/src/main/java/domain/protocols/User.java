package domain.protocols;

import java.util.UUID;

public class User {
    public UUID id;
    public String name;
    public String email;
    public String password;
    public User(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
