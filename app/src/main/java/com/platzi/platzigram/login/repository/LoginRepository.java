package com.platzi.platzigram.login.repository;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Raziel214 on 10/8/2017.
 */

public interface LoginRepository {

    void singIn(String username,String password,Activity activity,FirebaseAuth firebaseAuth);

}
