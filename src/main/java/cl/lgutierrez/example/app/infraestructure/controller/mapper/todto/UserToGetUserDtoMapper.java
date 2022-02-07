package cl.lgutierrez.example.app.infraestructure.controller.mapper.todto;

import cl.lgutierrez.example.app.api.model.GetUserDto;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.DomainToDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class UserToGetUserDtoMapper extends DomainToDtoMapper<User, GetUserDto> {

  public GetUserDto toDto(User user) {

    GetUserDto userDto = new GetUserDto();
    userDto.setId(user.getUuid().toString());
    userDto.setUsername(user.getUsername());
    userDto.setEmail(user.getEmail());

    return userDto;
  }
}
