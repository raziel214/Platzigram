package com.platzi.platzigram.login.interactor;

import com.platzi.platzigram.login.presenter.LoginPresenter;
import com.platzi.platzigram.login.repository.LoginRepository;
import com.platzi.platzigram.login.repository.LoginRepositoryImpl;

/**
 * Created by Raziel214 on 9/8/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {


    private LoginPresenter presenter;
    private LoginRepository repository;

    public LoginInteractorImpl(LoginPresenter presenter) {
        this.presenter = presenter;
        repository=new LoginRepositoryImpl(presenter);
    }

    @Override
    public void singIn(String username, String password) {
        repository.singIn(username,password);


    }
}
