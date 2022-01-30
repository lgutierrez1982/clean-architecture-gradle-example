package cl.lgutierrez.example.app.domain.port.input;

import cl.lgutierrez.example.app.domain.model.User;

public interface CreateUser {

  User execute(User user);

}
