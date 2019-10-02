package hello.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {
    @ApiOperation(
            value = "Returns a User Principal object",
            notes = "Used for Spring Boot OAuth2 example",
            response = Principal.class
    )
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal user(Principal principal){
        return principal;
    }
}
