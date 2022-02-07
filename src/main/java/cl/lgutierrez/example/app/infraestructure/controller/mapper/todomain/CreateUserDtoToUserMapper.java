package cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain;

import cl.lgutierrez.example.app.api.model.CreateUserDto;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.DtoToDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDtoToUserMapper extends DtoToDomainMapper<CreateUserDto, User> {

  @Override
  public User toDomain(CreateUserDto createUserDto) {
    return User.builder()
        .withUsername(createUserDto.getUsername())
        .withEmail(createUserDto.getEmail())
        .withPassword(createUserDto.getPassword())
        .build();
  }

}
