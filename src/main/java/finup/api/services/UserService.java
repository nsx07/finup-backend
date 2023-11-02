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
public class UserService extends BaseService<User, Long, UserRepository> {
    @Autowired
    public UserService() { }
}
