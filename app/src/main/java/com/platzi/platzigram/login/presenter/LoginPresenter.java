package com.platzi.platzigram.login.presenter;

/**
 * Created by Raziel214 on 9/8/2017.
 */

public interface LoginPresenter {

    void signIn (String username, String pasword);//interactor

    void loginSucces();

    void loginError(String error);
}
