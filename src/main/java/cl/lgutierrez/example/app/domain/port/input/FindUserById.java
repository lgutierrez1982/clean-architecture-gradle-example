package cl.lgutierrez.example.app.domain.port.input;

import cl.lgutierrez.example.app.domain.model.User;
import java.util.UUID;

public interface FindUserById {

  User execute(String uuid);
}
