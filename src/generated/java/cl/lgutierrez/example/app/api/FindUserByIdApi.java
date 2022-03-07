package cl.lgutierrez.example.app.api;

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

@Api(value = "findUserById", description = "the findUserById API")
public interface FindUserByIdApi {

    @ApiOperation(value = "", notes = "Returns user by id", response = GetUserDto.class, tags={ "users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A users", response = GetUserDto.class),
        @ApiResponse(code = 500, message = "Response with error.", response = GetUserDto.class) })
    @RequestMapping(value = "/findUserById/{userId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<GetUserDto> findUserById( @Min(1)@ApiParam(value = "get user by id",required=true ) @PathVariable("userId") Long userId);

}
