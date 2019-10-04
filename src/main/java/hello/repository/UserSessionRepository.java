package hello.repository;

import hello.entity.UserSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserSessionRepository extends CrudRepository<UserSession, Integer> {

    @Transactional(readOnly = true)
    public UserSession findBySession(String session);

    @Transactional(readOnly = true)
    public UserSession findByUsername(String username);
}
