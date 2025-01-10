package application.protocols;

import domain.protocols.User;
import domain.protocols.UserDTO;

public interface UserRepository {
    public User create(UserDTO dto) throws Exception;
}
