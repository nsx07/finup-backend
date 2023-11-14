package finup.api.services;

import finup.api.entity.User;
import finup.api.repository.UserRepository;
import finup.api.security.UserDetailsInfo;
import org.apache.catalina.security.SecurityClassLoad;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.security.auth.kerberos.EncryptionKey;
import java.security.CryptoPrimitive;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService extends BaseService<User, Long, UserRepository> implements UserDetailsService {
    @Autowired
    public UserService() { }

    @Autowired
    public PasswordEncoder passwordEncoder;

    public Optional<User> Login(String username, String password) {

        Optional<User> user = getRepository().getByEmail(username);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }

        return Optional.empty();
    }

    @Override
    public Boolean save(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.save(entity);
    }
    @Override
    public Boolean update(Long id, User entity) {
        String password = entity.getPassword();

        if (Objects.equals(entity.getPassword(), "")) {
            password = getRepository().getReferenceById(id).getPassword();
            entity.setPassword(password);
        } else{
            entity.setPassword(passwordEncoder.encode(password));
        }

        return super.update(entity.getId(), entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = getRepository().getByEmail(username);

        return user.isEmpty()
                ? null
                : new UserDetailsInfo(user.get().getPassword(), user.get().getEmail(), null);
    }
}
