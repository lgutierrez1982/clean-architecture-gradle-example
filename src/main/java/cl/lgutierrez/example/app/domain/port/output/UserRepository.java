package cl.lgutierrez.example.app.domain.port.output;

import cl.lgutierrez.example.app.domain.model.User;
import java.util.UUID;

public interface UserRepository {

  User findUserById(UUID uuid);

  User createUser(User user);
}
