package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.banchelorapp.mysql.BackgroundTask;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.AnimaleAdoptie;
import com.example.banchelorapp.utils.Proprietar;
import com.example.banchelorapp.utils.Salon;

import java.util.ArrayList;
import java.util.Date;

public class AuthentificationActivity extends AppCompatActivity {

    public static final String LOGIN_SHARED_PREF = "loginSharedPref";
    public static final String EMAIL = "Email";
    public static final String PAROLA = "Parola";
    Intent intent;
    EditText etParola;
    EditText etEmail;

    private SharedPreferences preferences;

    public static String email;
   public static ArrayList<Animal> listaAnimale;
   public static ArrayList<AnimaleAdoptie> listaAnimaleAdoptie;
   public static ArrayList<Salon> listaSaloane;
    public static boolean back=false;

    String typeAnimale="getAnimale";
    String typeAnimaleAdoptie="getAnimaleAdoptie";
    String typeSaloane="getSaloane";
    String type="login";

    public void creazaCont(View view){
        intent=new Intent(this,SignInActivity.class);
        startActivity(intent);
    }
    public void goToMain(View view){


        listaAnimale=new ArrayList<Animal>();
        listaAnimaleAdoptie=new ArrayList<AnimaleAdoptie>();
        listaSaloane=new ArrayList<Salon>();
        email=etEmail.getText().toString()!=null? etEmail.getText().toString():"";
        String parola=etParola.getText()!=null? etParola.getText().toString():"";




        BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
        backgroundTask.execute(type,email,parola);



        Date startMoment = new Date();
        while(!backgroundTask.corect){

            Date endMoment = new Date();
            int numSeconds = (int)((endMoment.getTime() - startMoment.getTime()) / 1000);
            if(numSeconds>0.5)
            {
                break;
            }

        }

        fetchData();
        fetchDataSalon();
        fetchDataAdoptii();

        if(backgroundTask.corect){

            //        SharedPreferences
//salvare in fisier
            SharedPreferences.Editor editor= preferences.edit() ;
            editor.putString(EMAIL,email);
            editor.putString(PAROLA,parola);
            editor.apply();
//SharedPreferences terminat

            intent=new Intent(this,MainActivity.class);

            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Email sau parola invalide",Toast.LENGTH_LONG).show();
        }
    }

    private void loadFromPreferences(){
        email=preferences.getString(EMAIL,"");
        String parolaSP=preferences.getString(PAROLA,"");

        //populare componente vizuale
        etEmail.setText(email);
        etParola.setText(parolaSP);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        etParola=findViewById(R.id.etParolaLogIn);
        etEmail=findViewById(R.id.etEmailLogIn);

        preferences=getSharedPreferences
                (LOGIN_SHARED_PREF,MODE_PRIVATE);
        loadFromPreferences();
    }


    public void fetchData() {
        BackgroundTask backgroundTaskAnimale=new BackgroundTask(getApplicationContext());
        backgroundTaskAnimale.execute(typeAnimale,AuthentificationActivity.email);
    }
    public void fetchDataSalon() {
        BackgroundTask backgroundTaskSaloane=new BackgroundTask(getApplicationContext());
        backgroundTaskSaloane.execute(typeSaloane);
    }
    public void fetchDataAdoptii() {
        BackgroundTask backgroundTaskAnimaleAdoptie=new BackgroundTask(getApplicationContext());
        backgroundTaskAnimaleAdoptie.execute(typeAnimaleAdoptie);
    }
    @Override
    public void onBackPressed() {
        back=true;
        if(!MainActivity.logout){
            super.onBackPressed();
        }
        else{
            this.finish();
            System.exit(0);
            return;
        }
    }
}