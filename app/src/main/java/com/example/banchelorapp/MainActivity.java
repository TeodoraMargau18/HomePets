package com.example.banchelorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.banchelorapp.mysql.BackgroundTask;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.Proprietar;
import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;
import com.google.android.material.navigation.NavigationView;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

import static com.example.banchelorapp.AuthentificationActivity.email;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Burger menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView tvNumeProp;
    TextView tvEmailProp;
    View hView;
    //-------

    public static boolean logout=false;

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
                if(AuthentificationActivity.listaAnimale.get(i).getCIP().equals(MainActivity.listaInterventii.get(j).getCipAnimal())){
                    AuthentificationActivity.listaAnimale.get(i).adaugaInterventie(MainActivity.listaInterventii.get(j));
                }
            for(int j=0;j<MainActivity.listaDeparazitari.size();j++)
                if(AuthentificationActivity.listaAnimale.get(i).getCIP().equals(MainActivity.listaDeparazitari.get(j).getCipAnimal())){
                    AuthentificationActivity.listaAnimale.get(i).adaugaDeparazitare(MainActivity.listaDeparazitari.get(j));
                }
            for(int j=0;j<MainActivity.listaVaccinuri.size();j++)
                if(AuthentificationActivity.listaAnimale.get(i).getCIP().equals(MainActivity.listaVaccinuri.get(j).getCipAnimal())){
                    AuthentificationActivity.listaAnimale.get(i).adaugaVaccin(MainActivity.listaVaccinuri.get(j));
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


        drawerLayout=findViewById(R.id.mainActivityIDDRawerTest);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        proprietarGeneral=new Proprietar(BackgroundTask.numeProprietar,BackgroundTask.prenumeProprietar,BackgroundTask.adresa,
                BackgroundTask.emailProp,BackgroundTask.numarTel,BackgroundTask.parola,AuthentificationActivity.listaAnimale);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=
                new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        hView=navigationView.getHeaderView(0);
        tvNumeProp=hView.findViewById(R.id.numeProprietarHeader);
        tvEmailProp= hView.findViewById(R.id.emailProprietarHeader);

        tvNumeProp.setText(BackgroundTask.numeProprietar+" "+BackgroundTask.prenumeProprietar);
        tvEmailProp.setText(email);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.myProfile);


        BackgroundTask backgroundTaskVaccinuri=new BackgroundTask(getApplicationContext());
        backgroundTaskVaccinuri.execute(typeVaccinuri);

        BackgroundTask backgroundTaskDeparazitari=new BackgroundTask(getApplicationContext());
        backgroundTaskDeparazitari.execute(typeDeparazitari);

        BackgroundTask backgroundTaskInterventii=new BackgroundTask(getApplicationContext());
        backgroundTaskInterventii.execute(typeInterventii);


        if(AuthentificationActivity.back){
            this.finish();
            System.exit(0);
        }

    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
        super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.myProfile:
                break;
            case R.id.detalii:
                break;
            case R.id.logOut:
                logout=true;
                Intent intent=new Intent(MainActivity.this,AuthentificationActivity.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}