package finup.api.services;

import finup.api.entity.User;
import finup.api.repository.UserRepository;
import org.apache.catalina.security.SecurityClassLoad;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.security.auth.kerberos.EncryptionKey;
import java.security.CryptoPrimitive;

@Service
public class UserService extends BaseService<User, Integer, UserRepository> {

    @Autowired
    public UserService() {
    }

    @Override
    public Boolean save(User user) {
        return super.save(user);
    }

    @Override
    public Boolean update(Integer id, User user) {
        return super.update(id, user);
    }
}
