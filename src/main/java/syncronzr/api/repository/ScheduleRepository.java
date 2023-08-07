package syncronzr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syncronzr.api.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

