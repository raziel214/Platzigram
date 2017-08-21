package com.platzi.platzigram.login.repository;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.platzi.platzigram.login.presenter.LoginPresenter;

/**
 * Created by Raziel214 on 10/8/2017.
 */

public class LoginRepositoryImpl implements LoginRepository {

    LoginPresenter presenter;


    public LoginRepositoryImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void singIn(String username, String password , Activity activity,FirebaseAuth firebaseAuth) {

        firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    presenter.loginSucces();
                }else{
                    presenter.loginError("Ocurrió un error");
                }
            }
        });
       /* boolean succes=true;
        if (succes){
            presenter.loginSucces();
        }
        else{
            presenter.loginError("Ocurrió un error");

        }*/

    }
}
