package finup.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import finup.api.entity.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
