package syncronzr.api.repository;

import syncronzr.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import syncronzr.api.entity.UserType;

public interface UserRepository extends JpaRepository<User, Long> {
}