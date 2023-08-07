package syncronzr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncronzr.api.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}

