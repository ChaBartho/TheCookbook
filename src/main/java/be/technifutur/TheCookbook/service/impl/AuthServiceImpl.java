package be.technifutur.TheCookbook.service.impl;

import be.technifutur.TheCookbook.form.LoginForm;
import be.technifutur.TheCookbook.form.SigninForm;
import be.technifutur.TheCookbook.jwt.JwtHolderDTO;
import be.technifutur.TheCookbook.jwt.JwtProvider;
import be.technifutur.TheCookbook.model.entity.User;
import be.technifutur.TheCookbook.repository.UserRepository;
import be.technifutur.TheCookbook.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;
    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder encoder,
            AuthenticationManager authManager,
            JwtProvider jwtProvider
    ) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }
    @Override
    public void register(SigninForm form) {
        User user = form.toEntity();
        user.setPassword( encoder.encode(user.getPassword()) );
        userRepository.save( user );
    }
    @Override
    public JwtHolderDTO login(LoginForm form) {
        Authentication auth = new UsernamePasswordAuthenticationToken(
                form.getUsername(),
                form.getPassword()
        );
        auth = authManager.authenticate( auth );
        String token = jwtProvider.createToken( auth );
        return new JwtHolderDTO( token );
    }
}