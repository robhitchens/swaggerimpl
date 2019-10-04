package hello.service;

import hello.entity.UserSession;
import hello.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional
                .ofNullable(userSessionRepository.findByUsername(username))
                .orElseThrow(() -> new RuntimeException(String.format("No User for userName: %s", username)))
                ;
    }

    public List<UserSession> findAllUserSession() {
        return StreamSupport
                .stream(userSessionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public UserSession findUserBySession(String session) {
        return Optional
                .ofNullable(userSessionRepository.findBySession(session))
                .orElseThrow(() -> new RuntimeException(String.format("No User for session: %s", session)));
    }

    public UserSession findUserByUsername(String username){
        return Optional
                .ofNullable(userSessionRepository.findByUsername(username))
                .orElseThrow(() -> new RuntimeException(String.format("No User for userName: %s", username)))
                ;
    }

    public void deleteUserSession(UserSession userSession){
        userSessionRepository.delete(userSession);
    }
}
