package cl.lgutierrez.example.app.infraestructure.controller;

import cl.lgutierrez.example.app.api.FindAllUsersApi;
import cl.lgutierrez.example.app.api.model.GetUsersDto;
import cl.lgutierrez.example.app.domain.port.input.FindAllUsers;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todto.UserToGetUserDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindAllUsersController implements FindAllUsersApi {

  private final FindAllUsers findAllUsers;
  private final UserToGetUserDtoMapper mapperToDto;

  public FindAllUsersController(FindAllUsers findAllUsers,
                                UserToGetUserDtoMapper mapperToDto) {
    this.findAllUsers = findAllUsers;
    this.mapperToDto = mapperToDto;
  }

  @Override
  public ResponseEntity<GetUsersDto> findAllUsers() {
    return ResponseEntity.ok(mapperToDto.toDto(findAllUsers.execute()));
  }
}
