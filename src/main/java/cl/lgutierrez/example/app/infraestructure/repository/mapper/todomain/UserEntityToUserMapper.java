package cl.lgutierrez.example.app.infraestructure.repository.mapper.todomain;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.EntityToDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserMapper extends EntityToDomainMapper<UserEntity, User> {

  @Override
  public User toDomain(UserEntity entity) {
    System.out.println("user entity " + entity.getUsername() + " " + entity.getPassword());
    User user = User.builder()
        .withUuid(entity.getUuid())
        .withUsername(entity.getUsername())
        .withEmail(entity.getEmail()).build();

    return user;
  }


}
