package cl.lgutierrez.example.app.domain.port.input;

import cl.lgutierrez.example.app.domain.model.User;
import java.util.List;

public interface FindAllUsers {

  List<User> execute();
}
