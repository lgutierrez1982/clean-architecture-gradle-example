package cl.lgutierrez.example.app.infraestructure.repository.adapter;

import cl.lgutierrez.example.app.domain.exception.UserNotFoundException;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.output.FindUserByIdRepository;
import cl.lgutierrez.example.app.infraestructure.repository.jpa.UserJpaRepository;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.todomain.UserEntityToUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdAdapterRepository implements FindUserByIdRepository {

  private final UserJpaRepository repository;
  private final UserEntityToUserMapper mapperToDomain;

  @Autowired
  public FindUserByIdAdapterRepository(UserJpaRepository repository,
                                       UserEntityToUserMapper mapperToDomain) {
    this.repository = repository;
    this.mapperToDomain = mapperToDomain;
  }

  @Override
  public User findUserById(Long id) {
    return this.mapperToDomain.toDomain(
        repository.findById(id)
            .orElseThrow(UserNotFoundException::new));
  }
}
