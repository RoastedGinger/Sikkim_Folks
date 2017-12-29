package com.example.robin.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText name;
    EditText pass;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
               if(firebaseAuth.getCurrentUser()!=null)
               {
                   Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                   startActivity(intent);
               }
            }

        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    public void login_now(View view) {
     String email = name.getText().toString();
     String pass1 = pass.getText().toString();
     if(TextUtils.isEmpty(email)||TextUtils.isEmpty(pass1))
     {
         Toast.makeText(this,"enter both values",Toast.LENGTH_SHORT).show();
     }
     else {
         auth.signInWithEmailAndPassword(email,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if(!task.isSuccessful())
                 {
                     Toast.makeText(Main2Activity.this,"Incorrect user name or password",Toast.LENGTH_LONG).show();;
                 }
             }
         });
     }

    }
}
