package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.banchelorapp.utils.AnimaleAdoptie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CentruAdoptiiActivity extends AppCompatActivity {
private GridView gridView;
    List<String> numeAnimale=new ArrayList<>();
    List<String> pozeAnimale=new ArrayList<String>();

    public static final String animalAdoptie="AnimalAdoptie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centru_adoptii);

        for(AnimaleAdoptie a : AuthentificationActivity.listaAnimaleAdoptie){
            numeAnimale.add(a.getNumeAnimal());
            pozeAnimale.add(a.getImagine());
            Log.e("In centru adoptii", "Am luat pozele si animalul");
        }

//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza1.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza3.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza4.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza5.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza6.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza7.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza8.jpg");
//
//        numeAnimale.add("Patrocle");
//        numeAnimale.add("NoName");
//        numeAnimale.add("Pisoias");
//        numeAnimale.add("Elefantel");
//        numeAnimale.add("Test");
//        numeAnimale.add("NoName2");
//        numeAnimale.add("Nebunu");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza1.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza3.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza4.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza5.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza6.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza7.jpg");
//        pozeAnimale.add("http://192.168.0.101/TestRegisterLogin/images/Salon/poza8.jpg");
//
//        numeAnimale.add("Patrocle");
//        numeAnimale.add("NoName");
//        numeAnimale.add("Pisoias");
//        numeAnimale.add("Elefantel");
//        numeAnimale.add("Test");
//        numeAnimale.add("NoName2");
//        numeAnimale.add("Nebunu");
//

        GridViewAdapter adapter = new GridViewAdapter(CentruAdoptiiActivity.this, numeAnimale, pozeAnimale);
        gridView = findViewById(R.id.gridAnimaleAdoptie);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopUpAdoptii popUp = new PopUpAdoptii();
                Bundle bundle = new Bundle();
                bundle.putParcelable(animalAdoptie, AuthentificationActivity.listaAnimaleAdoptie.get(position));

                popUp.setArguments(bundle);

                popUp.show(getSupportFragmentManager(), "PopUpAdoptii");
            }
        });
    }
}