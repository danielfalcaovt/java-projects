package domain.protocols;

public interface CreateUser {
    public User create(UserDTO dto) throws Exception;
}
