package com.platzi.platzigram.login.view;

/**
 * Created by Raziel214 on 8/8/2017.
 */

public interface LoginView {


    void enabledInputs();
    void disabledInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);

    void goCreateAccount();
    void goHome();
}
