package cl.lgutierrez.example.app.infraestructure.repository.adapter;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.output.FindAllUsersRepository;
import cl.lgutierrez.example.app.infraestructure.repository.jpa.UserJpaRepository;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.todomain.UserEntityToUserMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FindAllUsersAdapterRepository implements FindAllUsersRepository {

  private final UserJpaRepository repository;
  private final UserEntityToUserMapper mapperToDomain;

  public FindAllUsersAdapterRepository(UserJpaRepository repository,
                                       UserEntityToUserMapper mapperToDomain) {
    this.repository = repository;
    this.mapperToDomain = mapperToDomain;
  }

  @Override
  public List<User> findAllUsers() {
    return this.mapperToDomain.toDomain(repository.findAll());
  }
}
