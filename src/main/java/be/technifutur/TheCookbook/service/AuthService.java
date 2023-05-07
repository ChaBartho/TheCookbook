package be.technifutur.TheCookbook.service;

import be.technifutur.TheCookbook.form.LoginForm;
import be.technifutur.TheCookbook.form.SigninForm;
import be.technifutur.TheCookbook.jwt.JwtHolderDTO;

public interface AuthService {

    void register(SigninForm form);

    JwtHolderDTO login(LoginForm form );

}
