package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.banchelorapp.mysql.BackgroundTask;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.AnimaleAdoptie;

public class InfoAdoptie extends AppCompatActivity {

    CheckBox checkBox;
    Button btnAdoptInfo;
    AnimaleAdoptie animal;
    Context ctx;
    public static final String type="UpdateStare";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_adoptie);

        btnAdoptInfo=findViewById(R.id.btninfo_Adopt);
        checkBox=findViewById(R.id.check_info);
        checkBox.setChecked(false);
        checkBox.setText(R.string.sunt_de_acord);
        ctx=this.getApplicationContext();

        btnAdoptInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    Toast.makeText(InfoAdoptie.this, "Te asteptam la centru pentru a completa formularul de adoptie", Toast.LENGTH_LONG).show();

                    String id=AuthentificationActivity.listaAnimaleAdoptie.get(CentruAdoptiiActivity.pozitieAnimal).getID();
                    String statut="adoptat";
                    BackgroundTask backgroundTask=new BackgroundTask(ctx);
                    backgroundTask.execute(type,statut,id);
                    AuthentificationActivity.listaAnimaleAdoptie.remove(CentruAdoptiiActivity.pozitieAnimal);
                    for(AnimaleAdoptie a : AuthentificationActivity.listaAnimaleAdoptie)
                         Log.e("L-am sters?",a.toString());
                    finish();
                }
                else
                    Toast.makeText(InfoAdoptie.this, "Pentru a adopta trebuie sa iei la cunostinta cerintele de mai sus ", Toast.LENGTH_LONG).show();

            }
        });
    }
}