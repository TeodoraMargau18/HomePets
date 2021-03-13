package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AuthentificationActivity extends AppCompatActivity {

    Intent intent;

    public void creazaCont(View view){
        intent=new Intent(this,SignInActivity.class);
        startActivity(intent);
    }
    public void goToMain(View view){
        intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
    }
}