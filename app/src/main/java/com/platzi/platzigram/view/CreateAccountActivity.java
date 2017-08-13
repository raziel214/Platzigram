package com.platzi.platzigram.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.platzi.platzigram.login.view.LoginActivity;
import com.platzi.platzigram.R;

public class CreateAccountActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount), true);

        firebaseAuth= FirebaseAuth.getInstance();



        final TextInputEditText etEmail = (TextInputEditText) findViewById(R.id.email);
        final TextInputEditText etName=(TextInputEditText) findViewById(R.id.name);
        final TextInputEditText etUser=(TextInputEditText)findViewById(R.id.user);
        final TextInputEditText etPasword=(TextInputEditText) findViewById(R.id.password_createaccount);
        final TextInputEditText etConfirmPass=(TextInputEditText) findViewById(R.id.confirmPassword);





        final Button btnCreateAccount=(Button)findViewById(R.id.joinUs);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name=etName.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String user=etUser.getText().toString().trim();
                String password=etPasword.getText().toString().trim();
                String confirmmation=etConfirmPass.getText().toString().trim();


                if (email.equals("")){
                    Toast.makeText(getApplicationContext()," Enter email adress",Toast.LENGTH_SHORT).show();
                    return;
                }
                /*if (user.equals("")){

                    Toast.makeText(getApplicationContext()," Enter User name",Toast.LENGTH_SHORT).show();

                }
                if (name.equals("")){

                    Toast.makeText(getApplicationContext()," Enter  name",Toast.LENGTH_SHORT).show();

                }

                if (confirmmation.equals("")){

                    //Toast.makeText(getApplicationContext()," confirm  password",Toast.LENGTH_SHORT).show();
                    if (confirmmation.equals(pasword)){

                        Toast.makeText(getApplicationContext(),"Password invalid",Toast.LENGTH_SHORT).show();

                    }

                }


                */
                if (password.equals(confirmmation)){

                    //Toast.makeText(getApplicationContext()," Enter  password",Toast.LENGTH_SHORT).show();
                    if (password.equals("")){

                        Toast.makeText(getApplicationContext(),"Password invalid",Toast.LENGTH_SHORT).show();
                        return;

                    }

                }

                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(CreateAccountActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(!task.isSuccessful()){

                                    Toast.makeText(CreateAccountActivity.this, "Auth failed", Toast.LENGTH_SHORT).show();

                                }
                                else{

                                    startActivity(new Intent(CreateAccountActivity.this, LoginActivity.class));

                                    finish();
                                    
                                }

                            }
                        });





            }
        });

    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
