package cl.lgutierrez.example.app.api;

import cl.lgutierrez.example.app.api.model.ErrorResponse;
import cl.lgutierrez.example.app.api.model.GetUsersDto;

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

@Api(value = "findAllUsers", description = "the findAllUsers API")
public interface FindAllUsersApi {

    @ApiOperation(value = "", notes = "Returns all users", response = GetUsersDto.class, tags={ "users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of users.", response = GetUsersDto.class),
        @ApiResponse(code = 500, message = "Response with error.", response = GetUsersDto.class) })
    @RequestMapping(value = "/findAllUsers",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<GetUsersDto> findAllUsers();

}
