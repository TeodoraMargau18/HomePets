package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.banchelorapp.mysql.BackgroundTask;
import com.example.banchelorapp.utils.Proprietar;
import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity  {

    String typeVaccinuri="getVaccinuri";
    String typeDeparazitari="getDeparazitari";
    String typeInterventii="getInterventii";

    public static ArrayList<Vaccin> listaVaccinuri;
    public static ArrayList<Deparazitare> listaDeparazitari;
    public static ArrayList<Interventie> listaInterventii;
    public static Proprietar proprietarGeneral;

    Intent intent;
    public void frumuseteFunction(View view){
        Log.e("Test", "TextView Frumusete apasat");

        intent=new Intent(this,ListaSaloaneActivity.class);
        startActivity(intent);
    }
    public void sanatateFunction(View view){
        Log.e("Test", "TextView Sanatate apasat");
        Log.e("Test2", String.valueOf( AuthentificationActivity.listaAnimale.size()));

        for(int i=0;i<AuthentificationActivity.listaAnimale.size();i++){
            for(int j=0;j<MainActivity.listaInterventii.size();j++)
                if(!(AuthentificationActivity.listaAnimale.get(i).getOperatiiAnimal().contains(MainActivity.listaInterventii.get(j)))){
                    if(AuthentificationActivity.listaAnimale.get(i).getCIP().equals(MainActivity.listaInterventii.get(j).getCipAnimal())){
                        AuthentificationActivity.listaAnimale.get(i).adaugaInterventie(MainActivity.listaInterventii.get(j));
                    }
                }

            for(int j=0;j<MainActivity.listaDeparazitari.size();j++)
                if(!(AuthentificationActivity.listaAnimale.get(i).getDeparazitariAnimal().contains(MainActivity.listaDeparazitari.get(j)))){
                    if(AuthentificationActivity.listaAnimale.get(i).getCIP().equals(MainActivity.listaDeparazitari.get(j).getCipAnimal())){
                        AuthentificationActivity.listaAnimale.get(i).adaugaDeparazitare(MainActivity.listaDeparazitari.get(j));
                    }
                }

            for(int j=0;j<MainActivity.listaVaccinuri.size();j++)

                if(!(AuthentificationActivity.listaAnimale.get(i).getVaccinuriAnimal().contains(MainActivity.listaVaccinuri.get(j)))){
                    if (AuthentificationActivity.listaAnimale.get(i).getCIP().equals(MainActivity.listaVaccinuri.get(j).getCipAnimal())) {
                        AuthentificationActivity.listaAnimale.get(i).adaugaVaccin(MainActivity.listaVaccinuri.get(j));
                    }
                }
        }


    while(!(BackgroundTask.deparazitariTerminat&&BackgroundTask.interventiiTerminat&&BackgroundTask.vaccinuriTerminat)) { }
        intent = new Intent(this, AnimaleleMeleActivity.class);
        startActivity(intent);
    }
    public void adoptiiFunction(View view){
        intent=new Intent(this,CentruAdoptiiActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeparazitari=new ArrayList<>();
        listaInterventii=new ArrayList<>();
        listaVaccinuri=new ArrayList<>();


        proprietarGeneral=new Proprietar(BackgroundTask.numeProprietar,BackgroundTask.prenumeProprietar,BackgroundTask.adresa,
                BackgroundTask.emailProp,BackgroundTask.numarTel,BackgroundTask.parola,AuthentificationActivity.listaAnimale);



        BackgroundTask backgroundTaskVaccinuri=new BackgroundTask(getApplicationContext());
        backgroundTaskVaccinuri.execute(typeVaccinuri);

        BackgroundTask backgroundTaskDeparazitari=new BackgroundTask(getApplicationContext());
        backgroundTaskDeparazitari.execute(typeDeparazitari);

        BackgroundTask backgroundTaskInterventii=new BackgroundTask(getApplicationContext());
        backgroundTaskInterventii.execute(typeInterventii);



    }

}