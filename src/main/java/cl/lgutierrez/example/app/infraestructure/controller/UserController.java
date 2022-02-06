package cl.lgutierrez.example.app.infraestructure.controller;

import cl.lgutierrez.example.app.UsuariosApi;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.CreateUser;
import cl.lgutierrez.example.app.domain.port.input.FindUserById;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain.CreateUserDtoToUserMapper;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todto.UserToGetUserDtoMapper;
import cl.lgutierrez.example.app.model.CreateUserDto;
import cl.lgutierrez.example.app.model.GetUserDto;
import cl.lgutierrez.example.app.model.GetUsersDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UsuariosApi {

  private final FindUserById findUserById;
  private final CreateUser createUser;
  private final CreateUserDtoToUserMapper mapperToDomain;
  private final UserToGetUserDtoMapper mapperToDto;

  public UserController(FindUserById findUserById,
                        CreateUser createUser,
                        CreateUserDtoToUserMapper mapperToDomain,
                        UserToGetUserDtoMapper mapperToDto) {
    this.findUserById = findUserById;
    this.createUser = createUser;
    this.mapperToDomain = mapperToDomain;
    this.mapperToDto = mapperToDto;
  }

  @Override
  public ResponseEntity<GetUserDto> createUser(CreateUserDto createUserDto) {
    User userDb = createUser.execute(mapperToDomain.toDomain(createUserDto));
    return ResponseEntity.status(HttpStatus.CREATED).body(mapperToDto.toDto(userDb));
  }

  @Override
  public ResponseEntity<GetUsersDto> findAllUsers() {
    return null;
  }

  @Override
  public ResponseEntity<GetUserDto> findUserById(String userId) {
    return ResponseEntity.ok(this.mapperToDto.toDto(findUserById.execute(userId)));
  }

}
