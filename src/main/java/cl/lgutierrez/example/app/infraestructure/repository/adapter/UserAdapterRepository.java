package cl.lgutierrez.example.app.infraestructure.repository.adapter;

import cl.lgutierrez.example.app.domain.exception.UserNotFoundException;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.output.UserRepository;
import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;
import cl.lgutierrez.example.app.infraestructure.repository.jpa.UserJpaRepository;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.todomain.EntityToDomainMapper;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.toentity.DomainToEntityMapper;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdapterRepository implements UserRepository {

  private final UserJpaRepository repository;
  private final DomainToEntityMapper<User, UserEntity> mapperToEntity;
  private final EntityToDomainMapper<UserEntity, User> mapperToDomain;

  @Autowired
  public UserAdapterRepository(UserJpaRepository repository,
                               DomainToEntityMapper mapperToEntity,
                               EntityToDomainMapper mapperToDomain) {
    this.repository = repository;
    this.mapperToEntity = mapperToEntity;
    this.mapperToDomain = mapperToDomain;
  }

  @Override
  public User findUserById(UUID uuid) {
    return this.mapperToDomain.toDomain(
        repository.findById(uuid)
            .orElseThrow( () -> new UserNotFoundException()));
  }

  @Override
  public User createUser(User user) {
    UserEntity userEntity =  this.mapperToEntity.toEntity(user);
    return this.mapperToDomain.toDomain(this.repository.save(userEntity));
  }
}
