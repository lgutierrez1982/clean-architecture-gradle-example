package cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain;


import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.model.UserDTO;
import java.util.UUID;

public class DTOToUserMapper implements DTOToDomainMapper<UserDTO, User> {

  public User toDomain(UserDTO userDTO) {

    return User.builder()
        //.withUuid(UUID.fromString(userDTO.getId()))
        .withUsername(userDTO.getUsername())
        .withEmail(userDTO.getEmail())
        .build();
  }
}
