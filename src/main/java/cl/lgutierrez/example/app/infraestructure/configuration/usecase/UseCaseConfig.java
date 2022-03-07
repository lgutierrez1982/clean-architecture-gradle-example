package cl.lgutierrez.example.app.infraestructure.configuration.usecase;

import cl.lgutierrez.example.app.domain.port.input.CreateUser;
import cl.lgutierrez.example.app.domain.port.input.FindAllUsers;
import cl.lgutierrez.example.app.domain.port.input.FindUserById;
import cl.lgutierrez.example.app.domain.port.output.FindUserByIdRepository;
import cl.lgutierrez.example.app.domain.usecase.CreateUserUseCase;
import cl.lgutierrez.example.app.domain.usecase.FindAllUsersUseCase;
import cl.lgutierrez.example.app.domain.usecase.FindUserByIdUseCase;
import cl.lgutierrez.example.app.infraestructure.repository.adapter.CreateUserAdapterRepository;
import cl.lgutierrez.example.app.infraestructure.repository.adapter.FindAllUsersAdapterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

  /*User*/
  @Bean
  public FindAllUsers findAllUsers(FindAllUsersAdapterRepository findAllUsersAdapterRepository) {
    return new FindAllUsersUseCase(findAllUsersAdapterRepository);
  }

  @Bean
  public FindUserById findUserById(FindUserByIdRepository findUserByIdRepository) {
    return new FindUserByIdUseCase(findUserByIdRepository);
  }

  @Bean
  public CreateUser createUser(CreateUserAdapterRepository userAdapterRepository) {
    return new CreateUserUseCase(userAdapterRepository);
  }

}
