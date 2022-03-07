package cl.lgutierrez.example.app.domain.usecase;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.CreateUser;
import cl.lgutierrez.example.app.domain.port.output.CreateUserRepository;

public class CreateUserUseCase implements CreateUser {

  private final CreateUserRepository userRepository;

  public CreateUserUseCase(CreateUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User execute(User user) {
    return userRepository.createUser(user);
  }

}
