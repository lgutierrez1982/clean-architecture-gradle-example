package cl.lgutierrez.example.app.infraestructure.controller;

import cl.lgutierrez.example.app.UsuariosApi;
import cl.lgutierrez.example.app.domain.port.input.CreateUser;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain.DTOToDomainMapper;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todto.DomainToDTOMapper;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.FindUserById;
import cl.lgutierrez.example.app.model.UserDTO;
import cl.lgutierrez.example.app.model.UsersDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UsuariosApi {

  private final FindUserById findUserById;
  private final CreateUser createUser;
  private final DTOToDomainMapper<UserDTO, User> mapperToDomain;
  private final DomainToDTOMapper<User, UserDTO> mapperToDTO;

  public UserController(FindUserById findUserById,
                        CreateUser createUser,
                        DTOToDomainMapper mapperToDomain,
                        DomainToDTOMapper mapperToDTO) {
    this.findUserById = findUserById;
    this.createUser = createUser;
    this.mapperToDomain = mapperToDomain;
    this.mapperToDTO = mapperToDTO;
  }

  @Override
  public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
    User userDb = createUser.execute(mapperToDomain.toDomain(userDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(mapperToDTO.toDTO(userDb));
  }

  @Override
  public ResponseEntity<UsersDTO> findAllUsers() {
    return null;
  }

  @Override
  public ResponseEntity<UserDTO> findUserById(String userId) {
    return ResponseEntity.ok(this.mapperToDTO.toDTO(findUserById.execute(userId)));
  }
}
