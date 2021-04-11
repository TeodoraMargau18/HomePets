package com.example.banchelorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Burger menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    //-------

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

        drawerLayout=findViewById(R.id.mainActivityIDDRawerTest);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=
                new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.myProfile);
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

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}