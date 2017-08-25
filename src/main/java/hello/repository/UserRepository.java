package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.User;

/**
 * Created by neviim 2 on 24/08/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
