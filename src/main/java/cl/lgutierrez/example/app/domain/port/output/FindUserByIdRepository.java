package cl.lgutierrez.example.app.domain.port.output;

import cl.lgutierrez.example.app.domain.model.User;

public interface FindUserByIdRepository {
  User findUserById(Long id);
}
