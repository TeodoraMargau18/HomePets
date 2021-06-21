package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.banchelorapp.mysql.BackgroundTask;
import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {

    TextInputEditText tietNume;
    TextInputEditText tietPrenume;
    TextInputEditText tietAdresa;
    TextInputEditText tietEmail;
    TextInputEditText tietTelefon;
    TextInputEditText tietParola;

    Intent intent;

    public void goToLogin(View view){
        intent=new Intent(this,AuthentificationActivity.class);
        startActivity(intent);
    }
    public void inregistrareCuSuccess(View view){
        if(validareDate()) {
            Toast.makeText(this, getString(R.string.inregistrareEfectuata), Toast.LENGTH_LONG).show();
            intent = new Intent(this, AuthentificationActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        tietNume=findViewById(R.id.tietNume);
        tietPrenume=findViewById(R.id.tietPrenume);
        tietAdresa=findViewById(R.id.tietAdresa);
        tietEmail=findViewById(R.id.tietEmailInregistrare);
        tietTelefon=findViewById(R.id.tietTelefon);
        tietParola=findViewById(R.id. tietParola);
    }

    private boolean validareDate(){
        if(tietNume.getText()==null||tietNume.getText().toString().length()<3) {
            tietNume.setError(getString(R.string.camp_obligatoriu_nume));
            return false;
        }
        if(tietPrenume.getText().toString().length()<3){
            tietPrenume.setError(getString(R.string.camp_obligatoriu_prenume));
            return false;}
        if(tietTelefon.getText().toString().length()<10) {
            tietTelefon.setError(getString(R.string.camp_obligatoriu_telefon));
            return false;
        }
        if(tietParola.getText().toString().length()<8) {
            tietParola.setError(getString(R.string.camp_obligatoriu_parola));
            return false;
        }
        if(tietEmail.getText().toString().length()<1
                ||!(tietEmail.getText().toString().contains("@yahoo.com"))) {
            Log.e("nu contine @yahoo.com",tietEmail.getText().toString());
            if(!(tietEmail.getText().toString().contains("@gmail.com"))){
                tietEmail.setError(getString(R.string.camp_obligatoriu_email));
                Log.e("nu contine @gmail.com",tietEmail.getText().toString());
                return false;
            }

        }
        if(tietAdresa.getText().toString().length()<1) {
            tietAdresa.setError(getString(R.string.camp_obligatoriu));
            return false;
        }
        else{
            String nume=tietNume.getText().toString();
            String prenume=tietPrenume.getText().toString();
            String telefon=tietTelefon.getText().toString();
            String adresa=tietAdresa.getText().toString();
            String email=tietEmail.getText().toString();
            String parola=tietParola.getText().toString();
            String type="reg";
            BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
            backgroundTask.execute(type,email,parola,nume,prenume,adresa,telefon);

            Log.e("Validare date","A trecut de backgroundTask");

            return true;
        }
    }
}