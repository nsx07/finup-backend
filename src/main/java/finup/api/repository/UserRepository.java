package finup.api.repository;

import finup.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from users u", nativeQuery = true)
    List<User> listAll();

    @Query(value = "select * from users u where u.email = ?1 and u.password = ?2", nativeQuery = true)
    Optional<User> login(String username, String password);

    @Query(value = "select * from users u where u.email = ?1 limit 1", nativeQuery = true)
    Optional<User> getByEmail(String email);

}
