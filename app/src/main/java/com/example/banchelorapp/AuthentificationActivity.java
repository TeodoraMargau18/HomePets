package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banchelorapp.mysql.BackgroundTask;
import com.example.banchelorapp.utils.Animal;

import java.util.ArrayList;
import java.util.Date;

public class AuthentificationActivity extends AppCompatActivity {

    Intent intent;
    EditText etParola;
    EditText etEmail;
    public static String email;
    String typeAnimale="getAnimale";
   public static ArrayList<Animal> listaAnimale;

    public void creazaCont(View view){
        intent=new Intent(this,SignInActivity.class);
        startActivity(intent);
    }
    public void goToMain(View view){

        listaAnimale=new ArrayList<Animal>();
        email=etEmail.getText().toString();
        String parola=etParola.getText().toString();
        String type="login";

        BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
        backgroundTask.execute(type,email,parola);



        //------------?
        Date startMoment = new Date();
        while(!backgroundTask.corect){
            Date endMoment = new Date();
            int numSeconds = (int)((endMoment.getTime() - startMoment.getTime()) / 1000);
            if(numSeconds>0.2)
                break;
        }

        fetchData();

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

    public void fetchData() {
//Pentru GetAnimale Vreau lista de animaleee!!
        Log.e("Fetch Data","Am intrat");
        BackgroundTask backgroundTaskAnimale=new BackgroundTask(getApplicationContext());
        Log.e("Emailull",email);
        backgroundTaskAnimale.execute(typeAnimale,email);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        etParola=findViewById(R.id.etParolaLogIn);
        etEmail=findViewById(R.id.etEmailLogIn);
    }
}