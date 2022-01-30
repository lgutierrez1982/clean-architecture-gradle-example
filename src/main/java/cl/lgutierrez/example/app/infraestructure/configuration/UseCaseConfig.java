package cl.lgutierrez.example.app.infraestructure.configuration;

import cl.lgutierrez.example.app.domain.port.input.CreateUser;
import cl.lgutierrez.example.app.domain.port.input.FindUserById;
import cl.lgutierrez.example.app.domain.usecase.CreateUserUseCase;
import cl.lgutierrez.example.app.domain.usecase.FindUserByIdUseCase;
import cl.lgutierrez.example.app.infraestructure.repository.adapter.UserAdapterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

  @Bean
  public FindUserById findUserById(UserAdapterRepository userAdapterRepository) {
    return new FindUserByIdUseCase(userAdapterRepository);
  }

  @Bean
  public CreateUser createUser(UserAdapterRepository userAdapterRepository) {
    return new CreateUserUseCase(userAdapterRepository);
  }

}
