package cl.lgutierrez.example.app.domain.port.output;

import cl.lgutierrez.example.app.domain.model.User;

public interface CreateUserRepository {

  User createUser(User user);

}
