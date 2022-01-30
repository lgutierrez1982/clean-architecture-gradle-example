package cl.lgutierrez.example.app.infraestructure.configuration;

import cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain.DTOToDomainMapper;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todto.DomainToDTOMapper;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.todomain.EntityToDomainMapper;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.toentity.DomainToEntityMapper;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain.DTOToUserMapper;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todto.UserToDTOMapper;
import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.todomain.EntityToUserMapper;
import cl.lgutierrez.example.app.infraestructure.repository.mapper.toentity.UserToEntityMapper;
import cl.lgutierrez.example.app.model.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

  @Bean
  public EntityToDomainMapper<UserEntity, User> entityToUserMapper() {
    return new EntityToUserMapper();
  }

  @Bean
  public DomainToEntityMapper<User, UserEntity> userToEntityMapper() {
    return new UserToEntityMapper();
  }

  @Bean
  public DTOToDomainMapper<UserDTO, User> dtoToUserMapper() {
    return new DTOToUserMapper();
  }

  @Bean
  public DomainToDTOMapper<User, UserDTO> userToDTOMapper() {
    return new UserToDTOMapper();
  }


}
