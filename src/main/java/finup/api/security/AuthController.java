package finup.api.security;

import finup.api.entity.User;
import finup.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("auth")
public class AuthController {

    @Autowired
    private UserService _userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest request) {

        Optional<User> user = _userService.Login(
                request.getUsername(),
                request.getPassword());

        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(AuthResponse.wrongCredentials());
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(AuthResponse.logged(jwtService.generateToken(request.getUsername())));
        }

        return ResponseEntity.internalServerError().body(new AuthResponse(null, "Servidor falhou em logar usuário"));
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }


}
