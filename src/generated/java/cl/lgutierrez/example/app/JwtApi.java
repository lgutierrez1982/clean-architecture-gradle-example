package cl.lgutierrez.example.app;

import cl.lgutierrez.example.app.model.CreateUserDTO;
import cl.lgutierrez.example.app.model.ErrorResponse;
import cl.lgutierrez.example.app.model.GetUserDTO;

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

@Api(value = "jwt", description = "the jwt API")
public interface JwtApi {

    @ApiOperation(value = "", notes = "Create a user", response = GetUserDTO.class, tags={ "jwt", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "A user created.", response = GetUserDTO.class),
        @ApiResponse(code = 500, message = "Response with error.", response = GetUserDTO.class) })
    @RequestMapping(value = "/jwt",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<GetUserDTO> createUserWithoutJwt(@ApiParam(value = "User save"  ) @RequestBody CreateUserDTO userDTO);

}
