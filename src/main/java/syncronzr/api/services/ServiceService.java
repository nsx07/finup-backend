package syncronzr.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import syncronzr.api.entity.Service;
import syncronzr.api.entity.UserType;
import syncronzr.api.repository.ServiceRepository;
import syncronzr.api.repository.UserTypeRepository;

@org.springframework.stereotype.Service
public class ServiceService extends BaseService<Service, Long, ServiceRepository> {

    @Autowired
    public ServiceService() {
    }

}
