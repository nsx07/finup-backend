package syncronzr.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syncronzr.api.entity.Schedule;
import syncronzr.api.entity.UserType;
import syncronzr.api.repository.ScheduleRepository;
import syncronzr.api.repository.UserTypeRepository;

@Service
public class ScheduleService extends BaseService<Schedule, Long, ScheduleRepository> {

    @Autowired
    public ScheduleService() {
    }

}
