package cl.lgutierrez.example.app.domain.usecase;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import cl.lgutierrez.example.app.domain.port.output.FindAllUsersRepository;
import cl.lgutierrez.example.app.mocks.user.UserListMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindAllUsersUseCaseTest {

  @Mock
  private FindAllUsersRepository userRepository;

  @InjectMocks
  private FindAllUsersUseCase useCase;

  @BeforeEach
  public void setUp() {
    useCase = new FindAllUsersUseCase(userRepository);
  }

  @Test
  void should_return_users_list() {
    int numberOfInvocationExpected = 1;

    //GIVEN
    Mockito
        .when(userRepository.findAllUsers())
        .thenReturn(UserListMock.build_users());

    //WHEN
    useCase.execute();

    //THEN
    verify(userRepository, times(numberOfInvocationExpected))
        .findAllUsers();

  }

}
