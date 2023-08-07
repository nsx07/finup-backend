package syncronzr.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syncronzr.api.entity.ServiceType;
import syncronzr.api.repository.ServiceTypeRepository;

@Service
public class ServiceTypeService extends BaseService<ServiceType, Long, ServiceTypeRepository> {

    @Autowired
    public ServiceTypeService() {
    }

}
