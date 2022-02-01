package cl.lgutierrez.example.app.infraestructure.controller.mapper.todto;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.DomainToDTOMapper;
import cl.lgutierrez.example.app.model.GetUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserToGetUserDTOMapper extends DomainToDTOMapper<User, GetUserDTO> {

  public GetUserDTO toDTO(User user) {

    GetUserDTO userDTO = new GetUserDTO();
    userDTO.setId(user.getUuid().toString());
    userDTO.setUsername(user.getUsername());
    userDTO.setEmail(user.getEmail());

    return userDTO;
  }
}
