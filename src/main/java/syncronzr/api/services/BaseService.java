package syncronzr.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<TEntity, TKey, TRepository extends JpaRepository<TEntity, TKey>>  {

    @Autowired
    private TRepository repository;

    @Autowired
    public BaseService() {
    }

    public TRepository getRepository() {
        return repository;
    }

    public List<TEntity> get() {
        return repository.findAll();
    }

    public Optional<TEntity> getById(TKey id) {
        return repository.findById(id);
    }

    public Boolean save(TEntity entity) {
        try {
            repository.save(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean update(TKey id, TEntity entity) {
        try {
            Optional<TEntity> existentEntity = repository.findById(id);
            if (existentEntity.isPresent()) {
                repository.saveAndFlush(entity);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteById(TKey id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



}
