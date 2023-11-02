package finup.api.services;

import finup.api.entity.Bill;
import finup.api.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService extends BaseService<Bill, Long, BillRepository>{
    @Autowired
    public BillService(BillRepository repository) { }
}
