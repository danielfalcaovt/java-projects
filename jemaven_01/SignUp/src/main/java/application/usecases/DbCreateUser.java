package application.usecases;

import application.protocols.UserRepository;
import domain.protocols.CreateUser;
import domain.protocols.User;
import domain.protocols.UserDTO;

public class DbCreateUser implements CreateUser {
    public UserRepository repository;

    public DbCreateUser(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(UserDTO dto) throws Exception {
        return this.repository.create(dto);
    }
}
