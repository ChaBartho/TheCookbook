package be.technifutur.TheCookbook.controller;

import be.technifutur.TheCookbook.form.LoginForm;
import be.technifutur.TheCookbook.form.SigninForm;
import be.technifutur.TheCookbook.jwt.JwtHolderDTO;
import be.technifutur.TheCookbook.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController( AuthService authService) {
        this.authService = authService;
    }
    @CrossOrigin
    @PostMapping("/register")
    public void register(@RequestBody @Valid SigninForm form) throws Exception{
        authService.register( form );
    }
    @CrossOrigin
    @PostMapping("/sign_in")
    public JwtHolderDTO login(@RequestBody @Valid LoginForm form){
        return authService.login( form );
    }
}