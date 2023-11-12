package finup.api.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    private String token;
    private String message;

    public AuthResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    static AuthResponse wrongCredentials() {
        return new AuthResponse(null, "Credenciais incorretas");
    }

    static AuthResponse logged(String token) {
        return new AuthResponse(token, "Logado com sucesso");
    }

}
