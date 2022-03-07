package cl.lgutierrez.example.app.api;

import cl.lgutierrez.example.app.api.model.CreateUserDto;
import cl.lgutierrez.example.app.api.model.ErrorResponse;
import cl.lgutierrez.example.app.api.model.GetUserDto;

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

@Api(value = "createUser", description = "the createUser API")
public interface CreateUserApi {

    @ApiOperation(value = "", notes = "Create a user", response = GetUserDto.class, tags={ "users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "A user created.", response = GetUserDto.class),
        @ApiResponse(code = 500, message = "Response with error.", response = GetUserDto.class) })
    @RequestMapping(value = "/createUser",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<GetUserDto> createUser(@ApiParam(value = "User save"  ) @RequestBody CreateUserDto userDTO);

}
