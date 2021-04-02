package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    public void frumuseteFunction(View view){
        Log.e("Test", "TextView Frumusete apasat");
        intent=new Intent(this,ListaSaloaneActivity.class);
        startActivity(intent);
    }
    public void sanatateFunction(View view){
        Log.e("Test", "TextView Sanatate apasat");
        Log.e("Test2", String.valueOf( AuthentificationActivity.listaAnimale.size()));

        intent=new Intent(this,AnimaleleMeleActivity.class);
        startActivity(intent);

    }
    public void adoptiiFunction(View view){
        Log.e("Test", "TextView Adoptii apasat");
        intent=new Intent(this,CentruAdoptiiActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}