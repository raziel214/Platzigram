package com.platzi.platzigram.login.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.platzi.platzigram.login.presenter.LoginPresenter;
import com.platzi.platzigram.login.presenter.LoginPresenterImpl;
import com.platzi.platzigram.R;
import com.platzi.platzigram.view.ContainerActivity;
import com.platzi.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private FirebaseAuth firebaseAuth;

    private TextInputEditText username;
    private TextInputEditText password;
    private Button login;
    private ProgressBar progresbarLogin;
    private LoginPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextInputEditText etEmail=(TextInputEditText) findViewById(R.id.username);
        final TextInputEditText etPassword=(TextInputEditText) findViewById(R.id.password);
        firebaseAuth= FirebaseAuth.getInstance();

        username=(TextInputEditText) findViewById(R.id.username);
        password=(TextInputEditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        progresbarLogin=(ProgressBar)findViewById(R.id.progresbarLogin);
        hideProgressBar();
        presenter =new LoginPresenterImpl(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(username.equals(""))
                presenter.signIn(username.getText().toString(),password.getText().toString());
            }
        });








    }


    @Override
    public void enabledInputs() {
        username.setEnabled(true);
        password.setEnabled(true);
        login.setEnabled(true);
    }

    @Override
    public void disabledInputs() {
        username.setEnabled(false);
        password.setEnabled(false);
        login.setEnabled(false);

    }

    @Override
    public void showProgressBar() {
        progresbarLogin.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {
        progresbarLogin.setVisibility(View.GONE);

    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void goCreateAccount() {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    @Override
    public void goHome() {

        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);

    }


}