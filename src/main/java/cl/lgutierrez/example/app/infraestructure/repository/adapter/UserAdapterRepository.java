package cl.lgutierrez.example.app.infraestructure.repository.adapter;

import cl.lgutierrez.example.app.domain.exception.UserNotFoundException;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.output.UserRepository;
import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;
import cl.lgutierrez.example.app.infraestructure.repository.jpa.UserJpaRepository;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.todomain.UserEntityToUserMapper;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.toentity.CreateUserToEntityMapper;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAdapterRepository implements UserRepository {

  private final UserJpaRepository repository;
  private final CreateUserToEntityMapper mapperToEntity;
  private final UserEntityToUserMapper mapperToDomain;

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserAdapterRepository(UserJpaRepository repository,
                               CreateUserToEntityMapper mapperToEntity,
                               UserEntityToUserMapper mapperToDomain,
                               PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.mapperToEntity = mapperToEntity;
    this.mapperToDomain = mapperToDomain;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User findUserById(UUID uuid) {
    return this.mapperToDomain.toDomain(
        repository.findById(uuid)
            .orElseThrow(() -> new UserNotFoundException()));
  }

  @Override
  public User createUser(User user) {
    UserEntity userEntity = this.mapperToEntity.toEntity(user);
    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    return this.mapperToDomain.toDomain(this.repository.save(userEntity));
  }


}
