package cl.lgutierrez.example.app.infraestructure.controller;

import cl.lgutierrez.example.app.JwtApi;
import cl.lgutierrez.example.app.domain.model.User;
import cl.lgutierrez.example.app.domain.port.input.CreateUser;
import cl.lgutierrez.example.app.domain.port.input.FindUserById;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain.CreateUserDTOToUserMapper;
import cl.lgutierrez.example.app.infraestructure.controller.mapper.todto.UserToGetUserDTOMapper;
import cl.lgutierrez.example.app.model.CreateUserDTO;
import cl.lgutierrez.example.app.model.GetUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController implements JwtApi {

    private final FindUserById findUserById;
    private final CreateUser createUser;
    private final CreateUserDTOToUserMapper mapperToDomain;
    private final UserToGetUserDTOMapper mapperToDTO;

    public JwtController(FindUserById findUserById,
                          CreateUser createUser,
                          CreateUserDTOToUserMapper mapperToDomain,
                          UserToGetUserDTOMapper mapperToDTO) {
        this.findUserById = findUserById;
        this.createUser = createUser;
        this.mapperToDomain = mapperToDomain;
        this.mapperToDTO = mapperToDTO;
    }

    @Override
    public ResponseEntity<GetUserDTO> createUserWithoutJwt(CreateUserDTO createUserDTO) {
        User userDb = createUser.execute(mapperToDomain.toDomain(createUserDTO));
        System.out.println("lo crea jwt");
        return ResponseEntity.status(HttpStatus.CREATED).body(mapperToDTO.toDTO(userDb));
    }

    @Override
    public ResponseEntity<GetUserDTO> findUserById(String userId) {
        return ResponseEntity.ok(this.mapperToDTO.toDTO(findUserById.execute(userId)));
    }
}
