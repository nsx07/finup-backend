package finup.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import finup.api.entity.User;
import finup.api.entity.UserType;
import finup.api.repository.UserRepository;
import finup.api.repository.UserTypeRepository;

@Service
public class UserTypeService extends BaseService<UserType, Long, UserTypeRepository> {

    @Autowired
    public UserTypeService() {
    }

}
