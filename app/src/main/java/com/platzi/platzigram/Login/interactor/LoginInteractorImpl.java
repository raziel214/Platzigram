package com.platzi.platzigram.Login.interactor;

import com.platzi.platzigram.Login.presenter.LoginPresenter;

/**
 * Created by Raziel214 on 9/8/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {


    private LoginPresenter presenter;

    public LoginInteractorImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void singIn(String username, String Pasword) {

    }
}
