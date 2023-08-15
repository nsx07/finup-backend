package finup.api.repository;

import finup.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import finup.api.entity.UserType;

public interface UserRepository extends JpaRepository<User, Long> {
}
