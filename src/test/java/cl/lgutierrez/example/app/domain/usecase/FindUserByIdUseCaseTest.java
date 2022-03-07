package cl.lgutierrez.example.app.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.output.CreateUserRepository;
import cl.lgutierrez.example.app.domain.port.output.FindUserByIdRepository;
import cl.lgutierrez.example.app.mocks.user.UserMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindUserByIdUseCaseTest {

  @Mock
  private FindUserByIdRepository userRepository;

  @InjectMocks
  private FindUserByIdUseCase useCase;

  @BeforeEach
  public void setUp() {
    useCase = new FindUserByIdUseCase(userRepository);
  }

  @Test
  void should_return_user_by_id() {
    Long idExpected = 1L;
    int numberOfInvocationExpected = 1;
    String usernameExpected = "lgutierrez@afc.cl";

    //GIVEN
    Mockito
        .when(userRepository.findUserById(idExpected))
        .thenReturn(UserMock.build_with_id_1_and_username());

    //WHEN
    User user = useCase.execute(idExpected);

    //THEN
    verify(userRepository, times(numberOfInvocationExpected))
        .findUserById(idExpected);
    assertEquals(usernameExpected, user.getUsername());

  }

}
