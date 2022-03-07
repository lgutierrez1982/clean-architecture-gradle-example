package cl.lgutierrez.example.app.infraestructure.repository.mapper.toentity;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.DomainToEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateUserToEntityMapper extends DomainToEntityMapper<User, UserEntity> {

  @Override
  public UserEntity toEntity(User user) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUsername((user.getUsername()));
    userEntity.setPassword(user.getPassword());

    return userEntity;
  }
}
