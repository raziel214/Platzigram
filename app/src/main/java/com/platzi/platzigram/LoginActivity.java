package com.platzi.platzigram;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.platzi.platzigram.view.ContainerActivity;
import com.platzi.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextInputEditText etEmail=(TextInputEditText) findViewById(R.id.username);
        final TextInputEditText etPassword=(TextInputEditText) findViewById(R.id.password);
        firebaseAuth= FirebaseAuth.getInstance();


        Button btnLogin=(Button)findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email=etEmail.getText().toString().trim();
                String password=etPassword.getText().toString().trim();


                if(etEmail.equals("")){

                    Toast.makeText(LoginActivity.this, "proporcione nombre de usuario", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etPassword.equals("")){

                    Toast.makeText(getApplicationContext(),"Password invalid",Toast.LENGTH_SHORT).show();
                    return;

                }

                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Usuario o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    goHome();
                                }




                            }
                        });



            }
        });


    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
    public void goHome(){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }
}
