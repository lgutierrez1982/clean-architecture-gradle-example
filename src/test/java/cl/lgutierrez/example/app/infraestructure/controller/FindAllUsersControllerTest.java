package cl.lgutierrez.example.app.infraestructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.lgutierrez.example.app.api.model.GetUsersDto;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.FindAllUsers;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todto.UserToGetUserDtoMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class FindAllUsersControllerTest {

  @Mock
  private FindAllUsers useCase;

  @Mock
  private UserToGetUserDtoMapper mapperToDto;

  @InjectMocks
  private FindAllUsersController controller;

  @BeforeEach
  public void setUp() {
    controller = new FindAllUsersController(useCase, mapperToDto);
  }

  @Test
  void should_return_200_status_when_call_controller() {
    int statusExpected = 200;

    //GIVEN
    List<User> usersMock = new ArrayList<>();
    GetUsersDto getUsersDtoMock = new GetUsersDto();

    Mockito
        .when(useCase.execute())
        .thenReturn(usersMock);

    Mockito
        .when(mapperToDto.toDto(usersMock))
        .thenReturn(getUsersDtoMock);

    //WHEN
    ResponseEntity responseEntity = controller.findAllUsers();

    //THEN
    assertEquals(statusExpected, responseEntity.getStatusCodeValue());
  }

}
