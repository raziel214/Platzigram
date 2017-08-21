package com.platzi.platzigram.login.presenter;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.platzi.platzigram.login.interactor.LoginInteractor;
import com.platzi.platzigram.login.interactor.LoginInteractorImpl;
import com.platzi.platzigram.login.view.LoginView;

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
    public void signIn(String username, String pasword, Activity activity,FirebaseAuth firebaseAuth) {

        loginView.enabledInputs();
        loginView.showProgressBar();
        interactor.singIn(username,pasword, activity,firebaseAuth);




    }

    @Override
    public void loginSucces() {
        loginView.goHome();
        loginView.hideProgressBar();
    }

    @Override
    public void loginError(String error) {

        loginView.enabledInputs();
        loginView.hideProgressBar();
        loginView.loginError(error);

    }
}
