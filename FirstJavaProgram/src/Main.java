import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String message = "Hello, World!";
        System.out.println(message);
    }

    public static class HttpResponse<T> {
        Number statusCode = null;
        T body = null;
    }

    public static class HttpRequest<T> {
        T body = null;
    }
    public class CreateUserController {
        CreateUser DbCreateUser;
        CreateUserController(CreateUser dbCreateUser) {
            this.DbCreateUser = dbCreateUser;
        }
        HttpResponse<User> create(HttpRequest<UserDTO> req) {
            return this.DbCreateUser.create(req.body);
        }
    }

    static HttpResponse<T> ok(T body) {
        return new HttpResponse();
    }

    public abstract static class CreateUser {
        abstract User create(UserDTO user);
    }

    public static class DbCreateUser extends CreateUser {
        User create(UserDTO user) {
            return new User(user.name, user.username, user.email, user.password);
        }
    }

    public static class User {
        User(String name, String username, String email, String password) {
            this.email = email;
            this.name = name;
            this.password = password;
            this.username = username;
        }
        UUID id = UUID.randomUUID();
        String name;
        String username;
        String email;
        String password;
    }
    public static abstract class UserDTO {
        String name;
        String email;
        String username;
        String password;
    }
}