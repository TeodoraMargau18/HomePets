package com.example.banchelorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.banchelorapp.utils.Animal;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfilMedicalActivity extends AppCompatActivity {

    public static final String tranferAnimalProfil="ANIMAL_FRAGMENT";
    BottomNavigationView bottomNavigationView;
    Intent intent;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_medical);
        Log.e("Profil Medical","S-a deschis");
        intent=getIntent();
        Animal animal=(Animal)intent.getParcelableExtra(AnimaleleMeleActivity.tranferAnimal);
        Log.e("Profil Medical",animal.getCuloareAnimal());

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNav);

        BottomNavigationView.OnNavigationItemSelectedListener navListener=
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment=null;
                        Log.e("Profil Medical","Se Apeleaza ceva");
                        bundle=new Bundle();
//                        bundle.putParcelable
//                                (ProfilMedicalActivity.tranferAnimalProfil,animal);
                        switch (item.getItemId()){
                            case R.id.profilGeneralFragment:
                                selectedFragment=new ProfilGeneralFragment();
                                selectedFragment.setArguments(bundle);
                                getSupportFragmentManager().beginTransaction().
                                        replace(R.id.fragment_container,selectedFragment).commit();
                                break;
                            case R.id.interventiiFragment:
                                selectedFragment=new InterventiiFragment();
                                selectedFragment.setArguments(bundle);
                                getSupportFragmentManager().beginTransaction().
                                        replace(R.id.fragment_container,selectedFragment).commit();
                                break;
                            case R.id.deparazitariFragment:
                                selectedFragment=new DeparazitariFragment();
                                selectedFragment.setArguments(bundle);
                                getSupportFragmentManager().beginTransaction().
                                        replace(R.id.fragment_container,selectedFragment).commit();
                                break;
                            case R.id.vaccineFragment:
                                selectedFragment=VaccinuriFragment.newInstance(animal);
//                                selectedFragment.setArguments(bundle);
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.fragment_container,selectedFragment)
                                        .commit();
                                break;
                            case R.id.mainActivityID:
                                intent=new Intent(getApplicationContext(),MainActivity.class);
                               startActivity(intent);
                                break;
                        }
                        return  true;
                    }
                };

      bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new ProfilGeneralFragment()).commit();

    }



}