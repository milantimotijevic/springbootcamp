package app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mtimotijevic on 18.2.18..
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    public User findOneByUsername(String username);
}
