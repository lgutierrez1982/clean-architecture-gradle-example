package cl.lgutierrez.example.app.domain.port.input;

import cl.lgutierrez.example.app.domain.model.User;

public interface FindUserById {

  User execute(String uuid);
}
