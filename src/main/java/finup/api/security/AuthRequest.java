package finup.api.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class AuthRequest {

    private String username;
    private String password;

}
