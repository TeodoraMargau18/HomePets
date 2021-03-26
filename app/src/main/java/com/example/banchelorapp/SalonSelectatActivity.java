package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.banchelorapp.utils.Salon;

import java.util.ArrayList;

public class SalonSelectatActivity extends AppCompatActivity {

    public static String SERVICII_KEY="transferServicii";
    ViewFlipper viewFlipper;
    Intent intent;
    Bundle bundle;
    Salon salon;
    TextView tvNume;
    ListView lvProgram;

    public void goToServiciiActivity(View view){
        bundle=new Bundle();
        if(salon!=null) {
            bundle.putParcelable(SERVICII_KEY, salon);
            intent=new Intent(getApplicationContext(),ServiciiActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else{
            Log.e("goToServiciiActivity","Salonul este null");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_selectat);
        viewFlipper=findViewById(R.id.viewFlipperSalon);
        intent=getIntent();
        salon=intent.getParcelableExtra(ListaSaloaneActivity.SALON_KEY);
        if(salon!=null)
            Log.e("SalonSelectat", "S-a preluat salonul");

        flipperImages(R.drawable.salon1,3000);

        int images[]={R.drawable.poza1,R.drawable.poaza2};
        tvNume=findViewById(R.id.tvNumeSalonSelectat);
        lvProgram =findViewById(R.id.tvProgram);

        ArrayList<String> listaPrograme=new ArrayList<>();
        listaPrograme=salon.getProgram();

        tvNume.setText(salon.getNumeSalon());
        ArrayAdapter<String> programAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listaPrograme );
        lvProgram.setAdapter(programAdapter);

        for(int image:images){
            Log.i("SalonSelectatActivity","Am intrat in for");
            flipperImages(image,3000);
        }

    }

    public void flipperImages(int image, int interval) {
        ImageView img=new ImageView(this);
        img.setBackgroundResource(image);


        viewFlipper.addView(img);
        viewFlipper.setFlipInterval(interval);
        viewFlipper.startFlipping();

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);

    }

    public void goToProgramarileMeleActivity(View view) {
    }
}