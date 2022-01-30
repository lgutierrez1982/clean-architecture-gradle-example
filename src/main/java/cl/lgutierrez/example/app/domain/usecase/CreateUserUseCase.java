package cl.lgutierrez.example.app.domain.usecase;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.CreateUser;
import cl.lgutierrez.example.app.domain.port.output.UserRepository;

public class CreateUserUseCase implements CreateUser {

  private final UserRepository userRepository;

  public CreateUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User execute(User user) {
    return userRepository.createUser(user);
  }

}
