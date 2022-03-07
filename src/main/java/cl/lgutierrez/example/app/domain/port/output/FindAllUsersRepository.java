package cl.lgutierrez.example.app.domain.port.output;

import cl.lgutierrez.example.app.domain.model.User;
import java.util.List;

public interface FindAllUsersRepository {

  List<User> findAllUsers();

}
