package cl.lgutierrez.example.app.infraestructure.repository.mapper.todomain;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.EntityToDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserMapper extends EntityToDomainMapper<UserEntity, User> {

  @Override
  public User toDomain(UserEntity entity) {
    return User.builder()
        .withId(entity.getId())
        .withUsername(entity.getUsername()).build();
  }


}
