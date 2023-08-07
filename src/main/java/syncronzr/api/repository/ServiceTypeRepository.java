package syncronzr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncronzr.api.entity.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
