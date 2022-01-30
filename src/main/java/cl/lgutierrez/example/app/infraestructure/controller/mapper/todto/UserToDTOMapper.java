package cl.lgutierrez.example.app.infraestructure.controller.mapper.todto;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.model.UserDTO;

public class UserToDTOMapper implements DomainToDTOMapper<User, UserDTO> {

  public UserDTO toDTO(User user) {

    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getUuid().toString());
    userDTO.setUsername(user.getUsername());
    userDTO.setEmail(user.getEmail());

    return userDTO;
  }
}
