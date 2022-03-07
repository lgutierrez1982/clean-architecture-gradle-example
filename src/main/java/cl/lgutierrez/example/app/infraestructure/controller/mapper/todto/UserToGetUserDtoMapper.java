package cl.lgutierrez.example.app.infraestructure.controller.mapper.todto;

import cl.lgutierrez.example.app.api.model.GetUserDto;
import cl.lgutierrez.example.app.api.model.GetUsersDto;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.DomainToDtoMapper;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserToGetUserDtoMapper extends DomainToDtoMapper<User, GetUserDto> {

  public GetUserDto toDto(User user) {

    GetUserDto userDto = new GetUserDto();
    userDto.setId(user.getId());
    userDto.setUsername(user.getUsername());

    return userDto;
  }

  @Override
  public GetUsersDto toDto(List<User> values) {
    GetUsersDto listUserDto = new GetUsersDto();
    for (User value : values) {
      listUserDto.add(toDto(value));
    }
    return listUserDto;
  }

}
