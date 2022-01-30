package cl.lgutierrez.example.app.infraestructure.repository.mapper.toentity;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;

public class UserToEntityMapper implements DomainToEntityMapper<User, UserEntity> {

  @Override
  public UserEntity toEntity(User user) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUuid((user.getUuid()));
    userEntity.setUsername((user.getUsername()));
    userEntity.setEmail(user.getEmail());

    return userEntity;
  }


}
