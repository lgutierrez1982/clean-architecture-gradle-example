package cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain;

import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.DTOToDomainMapper;
import cl.lgutierrez.example.app.model.CreateUserDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDTOToUserMapper extends DTOToDomainMapper<CreateUserDTO, User> {

    @Override
    public User toDomain(CreateUserDTO createUserDTO) {
        return User.builder()
            .withUsername(createUserDTO.getUsername())
            .withEmail(createUserDTO.getEmail())
            .withPassword(createUserDTO.getPassword())
            .build();
    }

}
