package cl.lgutierrez.example.app.domain.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.output.CreateUserRepository;
import cl.lgutierrez.example.app.mocks.user.UserMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

  @Mock
  private CreateUserRepository repository;

  @InjectMocks
  private CreateUserUseCase useCase;

  @BeforeEach
  public void setup() {
    useCase = new CreateUserUseCase(repository);
  }

  @Test
  void should_create_user_in_repository() {
    int numberOfInvocationExpected = 1;
    Long idExpected = 5L;

    //GIVEN
    Mockito
        .doAnswer(new Answer() {

          Long sequence = 5L;

          @Override
          public User answer(InvocationOnMock invocation) throws Throwable {
            User user = invocation.getArgument(0);
            return user.builder()
                .withId(sequence++).build();
          }
        }).when(repository).createUser(any(User.class));

    //WHEN
    User user = useCase.execute(UserMock.build_without_id_and_with_username());

    //THEN
    verify(repository, times(numberOfInvocationExpected))
        .createUser(any(User.class));
    assertEquals(idExpected, user.getId());

  }


}