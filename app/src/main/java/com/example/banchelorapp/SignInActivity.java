package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    Intent intent;
    public void goToLogin(View view){
        intent=new Intent(this,AuthentificationActivity.class);
        startActivity(intent);
    }
    public void inregistrareCuSuccess(View view){
        Toast.makeText(this, getString(R.string.inregistrareEfectuata), Toast.LENGTH_LONG).show();
        intent=new Intent(this,AuthentificationActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
}