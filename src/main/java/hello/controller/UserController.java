package hello.controller;

import hello.entity.UserSession;
import hello.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(
            value = "Returns a User Principal object",
            notes = "Used for Spring Boot OAuth2 example",
            response = Principal.class
    )
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal user(HttpServletRequest httpServletRequest, Principal principal){
        UserSession userSession = new UserSession();
        userSession.setUsername(principal.getName());
        userSession.setPassword(principal.getName());
        userSession.setSession(String.valueOf(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)));
        return principal;
    }
}
