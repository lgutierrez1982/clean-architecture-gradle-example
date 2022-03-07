package cl.lgutierrez.example.app.domain.usecase;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.FindUserById;
import cl.lgutierrez.example.app.domain.port.output.FindUserByIdRepository;

public class FindUserByIdUseCase implements FindUserById {

  private final FindUserByIdRepository findUserByIdRepository;

  public FindUserByIdUseCase(FindUserByIdRepository findUserByIdRepository) {
    this.findUserByIdRepository = findUserByIdRepository;
  }

  @Override
  public User execute(Long id) {
    return findUserByIdRepository.findUserById(id);
  }

}
