package cl.lgutierrez.example.app;

import cl.lgutierrez.example.app.model.ErrorResponse;
import cl.lgutierrez.example.app.model.UserDTO;
import cl.lgutierrez.example.app.model.UsersDTO;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;

@Api(value = "usuarios", description = "the usuarios API")
public interface UsuariosApi {

    @ApiOperation(value = "", notes = "Create a user", response = UserDTO.class, tags={ "usuarios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "A user created.", response = UserDTO.class),
        @ApiResponse(code = 500, message = "Response with error.", response = UserDTO.class) })
    @RequestMapping(value = "/usuarios",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<UserDTO> createUser(@ApiParam(value = "User save"  ) @RequestBody UserDTO userDTO);


    @ApiOperation(value = "", notes = "Returns all users", response = UsersDTO.class, tags={ "usuarios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of users.", response = UsersDTO.class),
        @ApiResponse(code = 500, message = "Response with error.", response = UsersDTO.class) })
    @RequestMapping(value = "/usuarios",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<UsersDTO> findAllUsers();


    @ApiOperation(value = "", notes = "Returns user by id", response = UserDTO.class, tags={ "usuarios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A users", response = UserDTO.class),
        @ApiResponse(code = 500, message = "Response with error.", response = UserDTO.class) })
    @RequestMapping(value = "/usuarios/{userId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<UserDTO> findUserById( @Pattern(regexp="^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$") @Min(1)@ApiParam(value = "get user by id",required=true ) @PathVariable("userId") String userId);

}
