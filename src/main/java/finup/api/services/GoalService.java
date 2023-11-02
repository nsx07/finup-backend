package finup.api.services;

import finup.api.entity.Goal;
import finup.api.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService extends BaseService<Goal, Long, GoalRepository> {
    @Autowired
    public GoalService(GoalRepository repository) {

    }
}
