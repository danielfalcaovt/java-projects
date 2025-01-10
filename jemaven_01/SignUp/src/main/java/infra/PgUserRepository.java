package infra;

import application.protocols.UserRepository;
import domain.protocols.User;
import domain.protocols.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PgUserRepository implements UserRepository {
    private final Connection connection;

    public PgUserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User create(UserDTO dto) throws Exception {
        final String SQL_INSTRUCTION = "INSERT INTO users(id, name, email, password) VALUES(?, ?, ?, ?)";
        PreparedStatement pst = this.connection.prepareStatement(SQL_INSTRUCTION);
        UUID userId = UUID.randomUUID();
        pst.setString(1, String.valueOf(userId));
        pst.setString(2, dto.getNome());
        pst.setString(3, dto.getEmail());
        pst.setString(4, dto.getPassword());
        pst.execute();
        return new User(userId, dto.getNome(), dto.getEmail(), dto.getPassword());
    }

    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        final String GET_INSTRUCTION = "SELECT * FROM users";
        PreparedStatement statement = this.connection.prepareStatement(GET_INSTRUCTION);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String column1 = result.getString("id");
            String column2 = result.getString("name");
            String column3 = result.getString("email");
            String column4 = result.getString("password");
            users.add(new User(UUID.fromString(column1), column2, column3, column4));
        }
        return users;
    }
}
