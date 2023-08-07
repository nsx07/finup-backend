package syncronzr.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syncronzr.api.entity.User;
import syncronzr.api.entity.UserType;
import syncronzr.api.repository.UserRepository;
import syncronzr.api.repository.UserTypeRepository;

@Service
public class UserTypeService extends BaseService<UserType, Long, UserTypeRepository> {

    @Autowired
    public UserTypeService() {
    }

}
