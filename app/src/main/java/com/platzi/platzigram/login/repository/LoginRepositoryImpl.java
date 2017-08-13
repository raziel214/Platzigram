package com.platzi.platzigram.login.repository;

import com.platzi.platzigram.login.presenter.LoginPresenter;

/**
 * Created by Raziel214 on 10/8/2017.
 */

public class LoginRepositoryImpl implements LoginRepository {

    LoginPresenter presenter;

    public LoginRepositoryImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void singIn(String username, String password) {

        boolean succes=true;
        if (succes){
            presenter.loginSucces();
        }
        else{
            presenter.loginError("Ocurrió un error");

        }

    }
}
