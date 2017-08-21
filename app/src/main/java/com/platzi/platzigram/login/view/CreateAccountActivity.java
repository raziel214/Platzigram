package com.platzi.platzigram.login.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.platzi.platzigram.R;

public class CreateAccountActivity extends AppCompatActivity {

    private static final String  TAG = "CreateAccountActivity";
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private TextInputEditText etEmail,etName,etUser,etPasword,etConfirmPass;
    private Button btnCreateAccount;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount), true);


        etEmail = (TextInputEditText) findViewById(R.id.email);
        etName=(TextInputEditText) findViewById(R.id.name);
        etUser=(TextInputEditText)findViewById(R.id.user);
        etPasword=(TextInputEditText) findViewById(R.id.password_createaccount);
        etConfirmPass=(TextInputEditText) findViewById(R.id.confirmPassword);
        btnCreateAccount=(Button)findViewById(R.id.joinUs);
        firebaseAuth= FirebaseAuth.getInstance();

        authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                if(firebaseUser!=null){
                    Log.w(TAG,"Usuario Logueado"+firebaseUser.getEmail() );
                }else{
                    Log.w(TAG,"Usuario no Logueado" );
                }
            }
        };

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createAccount();
            }
        });


    }

    private void createAccount() {
        String email=etEmail.getText().toString();
        String password=etPasword.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(CreateAccountActivity.this,"Cuenta creada exitosamente",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CreateAccountActivity.this,"Ocurrio un error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        firebaseAuth.removeAuthStateListener(authStateListener);
    }


}
