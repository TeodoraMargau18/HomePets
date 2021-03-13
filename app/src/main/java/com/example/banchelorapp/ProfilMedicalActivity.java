package com.example.banchelorapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfilMedicalActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_medical);
        Log.e("Profil Medical","S-a deschis");


        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNav);
        BottomNavigationView.OnNavigationItemSelectedListener navListener=
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment=null;
                        Log.e("Profil Medical","Se Apeleaza ceva");
                        switch (item.getItemId()){
                            case R.id.profilGeneralFragment:
                                selectedFragment=new ProfilGeneralFragment();
                                break;
                            case R.id.interventiiFragment:
                                selectedFragment=new InterventiiFragment();
                                break;
                            case R.id.deparazitariFragment:
                                selectedFragment=new DeparazitariFragment();
                                break;
                            case R.id.vaccineFragment:
                                selectedFragment=new VaccineFragment();
                                break;
                        }

                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.fragment_container,selectedFragment).commit();
                        return  true;
                    }
                };

      bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new ProfilGeneralFragment()).commit();

    }



}