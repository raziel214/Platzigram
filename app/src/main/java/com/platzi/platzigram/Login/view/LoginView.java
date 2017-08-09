package com.platzi.platzigram.Login.view;

/**
 * Created by Raziel214 on 8/8/2017.
 */

public interface LoginView {


    void anabledInputs();
    void disabledInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError();

    void goCreateAccount();
    void goHome();
}
