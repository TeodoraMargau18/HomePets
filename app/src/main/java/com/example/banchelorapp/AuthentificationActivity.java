package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banchelorapp.mysql.BackgroundTask;

public class AuthentificationActivity extends AppCompatActivity {

    Intent intent;
    EditText etParola;
    EditText etEmail;

    public void creazaCont(View view){
        intent=new Intent(this,SignInActivity.class);
        startActivity(intent);
    }
    public void goToMain(View view){
        String email=etEmail.getText().toString();
        String parola=etParola.getText().toString();
        String type="login";
        BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
        backgroundTask.execute(type,email,parola);
        Log.e("Cevaaaaaaaaaa", String.valueOf(backgroundTask.corect));

        //------------?

        while(backgroundTask.eTermimnat==false){
            Log.e("Ath WHILE", String.valueOf(backgroundTask.eTermimnat));
        }
        if(backgroundTask.corect){
            Log.e("Ath IF","E pe IF");
            intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        //------------?
        else{
            Log.e("Ath ELSE","E pe else");
            Toast.makeText(getApplicationContext(),"Email sau parola invalide",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        etParola=findViewById(R.id.etParolaLogIn);
        etEmail=findViewById(R.id.etEmailLogIn);
    }
}