package cl.lgutierrez.example.app.infraestructure.controller;

import cl.lgutierrez.example.app.api.CreateUserApi;
import cl.lgutierrez.example.app.api.model.CreateUserDto;
import cl.lgutierrez.example.app.api.model.GetUserDto;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.CreateUser;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain.CreateUserDtoToUserMapper;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todto.UserToGetUserDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController implements CreateUserApi {

  private final CreateUser createUser;
  private final CreateUserDtoToUserMapper mapperToDomain;
  private final UserToGetUserDtoMapper mapperToDto;

  public CreateUserController(CreateUser createUser,
                              CreateUserDtoToUserMapper mapperToDomain,
                              UserToGetUserDtoMapper mapperToDto) {
    this.createUser = createUser;
    this.mapperToDomain = mapperToDomain;
    this.mapperToDto = mapperToDto;
  }

  @Override
  public ResponseEntity<GetUserDto> createUser(CreateUserDto createUserDto) {
    User userDb = createUser.execute(mapperToDomain.toDomain(createUserDto));
    return ResponseEntity.status(HttpStatus.CREATED).body(mapperToDto.toDto(userDb));
  }


}
