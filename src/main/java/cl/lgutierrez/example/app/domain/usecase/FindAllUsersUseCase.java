package cl.lgutierrez.example.app.domain.usecase;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.FindAllUsers;
import cl.lgutierrez.example.app.domain.port.output.FindAllUsersRepository;
import java.util.List;

public class FindAllUsersUseCase implements FindAllUsers {

  private final FindAllUsersRepository findAllUsersRepository;

  public FindAllUsersUseCase(FindAllUsersRepository findAllUsersRepository) {
    this.findAllUsersRepository = findAllUsersRepository;
  }

  @Override
  public List<User> execute() {
    return this.findAllUsersRepository.findAllUsers();
  }
}
