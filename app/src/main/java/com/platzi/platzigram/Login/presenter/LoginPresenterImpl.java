package com.platzi.platzigram.Login.presenter;

import com.platzi.platzigram.Login.interactor.LoginInteractor;
import com.platzi.platzigram.Login.interactor.LoginInteractorImpl;
import com.platzi.platzigram.Login.view.LoginView;

/**
 * Created by Raziel214 on 9/8/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        interactor=new LoginInteractorImpl(this);
    }

    @Override
    public void signIn(String username, String pasword) {

        interactor.singIn(username,pasword);


    }

    @Override
    public void loginSucces() {

    }

    @Override
    public void loginError() {

    }
}
