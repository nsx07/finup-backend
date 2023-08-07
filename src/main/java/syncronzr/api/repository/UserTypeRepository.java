package syncronzr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncronzr.api.entity.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
