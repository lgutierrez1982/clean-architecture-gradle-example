package cl.lgutierrez.example.app.domain.usecase;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.FindUserById;
import cl.lgutierrez.example.app.domain.port.output.UserRepository;
import java.util.UUID;

public class FindUserByIdUseCase implements FindUserById {

  private final UserRepository userRepository;

  public FindUserByIdUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User execute(String uuid) {
    return userRepository.findUserById(UUID.fromString(uuid));
  }

}
