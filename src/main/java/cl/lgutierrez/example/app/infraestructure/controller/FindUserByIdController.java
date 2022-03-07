package cl.lgutierrez.example.app.infraestructure.controller;

import cl.lgutierrez.example.app.api.FindUserByIdApi;
import cl.lgutierrez.example.app.api.model.GetUserDto;
import cl.lgutierrez.example.app.domain.port.input.FindUserById;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todto.UserToGetUserDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindUserByIdController implements FindUserByIdApi {

  private final FindUserById findUserById;
  private final UserToGetUserDtoMapper mapperToDto;

  public FindUserByIdController(FindUserById findUserById,
                                UserToGetUserDtoMapper mapperToDto) {
    this.findUserById = findUserById;
    this.mapperToDto = mapperToDto;
  }

  @Override
  public ResponseEntity<GetUserDto> findUserById(Long userId) {
    return ResponseEntity.ok(this.mapperToDto.toDto(findUserById.execute(userId)));
  }
}
