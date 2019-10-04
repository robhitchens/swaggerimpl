package hello.interceptor;

import hello.entity.UserSession;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SessionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Value("${user.session.custom.timeout}")
    private long timeout;

    //TODO this is all garbage

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserSession userSession = userService.findUserByUsername(request.getUserPrincipal().getName());
        if(Long.parseLong(userSession.getSession()) + timeout < LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)){
            request.getSession(false).invalidate();
            userService.deleteUserSession(userSession);
            return false;
        }
        return true;
    }
}
