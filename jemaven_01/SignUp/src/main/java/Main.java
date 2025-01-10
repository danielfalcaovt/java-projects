import application.usecases.DbCreateUser;
import domain.protocols.User;
import domain.protocols.UserDTO;
import infra.PgUserRepository;
import main.helpers.PgHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try{
            Connection connection = PgHelper.createConnection();
            PgUserRepository repository = new PgUserRepository(connection);
            DbCreateUser dbCreateUser = new DbCreateUser(repository);
            User createdUser = dbCreateUser.create(new UserDTO("deenedev", "deenedev@gmail.com",  "password"));
            List<User> users = repository.getAll();
            for (User user : users) {
                System.out.println(user.email);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
