package com.platzi.platzigram.login.presenter;

import android.app.Activity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Raziel214 on 9/8/2017.
 */

public interface LoginPresenter {

    void signIn (String username, String pasword,Activity activity,FirebaseAuth firebaseAuth);//interactor

    void loginSucces();

    void loginError(String error);


}
