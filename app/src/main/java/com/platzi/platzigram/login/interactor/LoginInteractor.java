package com.platzi.platzigram.login.interactor;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Raziel214 on 9/8/2017.
 */

public interface LoginInteractor {

    void singIn(String username,String Pasword,Activity activity,FirebaseAuth firebaseAuth);

}
