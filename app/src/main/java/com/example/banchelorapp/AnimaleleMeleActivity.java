package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.banchelorapp.adapter.ListaAnimaleAdapter;
import com.example.banchelorapp.mysql.BackgroundTask;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class AnimaleleMeleActivity extends AppCompatActivity {

    public static Context ctx;
    Intent intent;
    public static final String tranferAnimal="ANIMAL";
   ListView animalListView;
   public static String pozaAnimal;
   public static int notificationID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animalele_mele);

        ctx=this.getApplicationContext();
        animalListView=findViewById(R.id.animalsListView);

        ListaAnimaleAdapter adapter=new ListaAnimaleAdapter
                (this,R.layout.lista_animale_adapter,AuthentificationActivity.listaAnimale);

        animalListView.setAdapter(adapter);

        animalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogFragmentAnimal dialogFragmentAnimal=new DialogFragmentAnimal();
                Bundle bundle = new Bundle();
                bundle.putParcelable(tranferAnimal, AuthentificationActivity.listaAnimale.get(position));

                dialogFragmentAnimal.setArguments(bundle);

                dialogFragmentAnimal.show(getSupportFragmentManager(),"MyDialogFragment");
            }
        });
        animalListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                intent=new Intent(getApplicationContext(),ProfilMedicalActivity.class);
              intent.putExtra(AnimaleleMeleActivity.tranferAnimal,AuthentificationActivity.listaAnimale.get(position));
                pozaAnimal=AuthentificationActivity.listaAnimale.get(position).getImagine();
                startActivity(intent);

                return true;
            }
        });
        for(Animal a :AuthentificationActivity.listaAnimale){
            for(Vaccin v : a.getVaccinuriAnimal())
            {
                getPerioada(v.getDataViitoareiVaccinări(),"VACCIN",a);
                
            }
            for(Deparazitare d : a.getDeparazitariAnimal())
            {
                getPerioada(d.getDataViitoareiDeparazitari(),"DEPARAZITARE",a);

            }
        }

        //Pt notificari
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
    public void sendNotification(String scop,String text) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(AnimaleleMeleActivity.this, "My Notification");
        builder.setContentTitle(scop.toUpperCase());
        builder.setContentText(text);
        builder.setSmallIcon(R.drawable.fundalalbastrulogo);


        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(AnimaleleMeleActivity.this);
        managerCompat.notify(notificationID, builder.build());
        notificationID++;
    }
    public void getPerioada(Date dataDePrelucrat,String scop,Animal a)
    {
        LocalDate today = LocalDate.now();
        LocalDate dataPrelucrata=dataDePrelucrat.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period p=Period.between(today,dataPrelucrata);
        if(p.getYears()==0&&p.getMonths()==0&&p.getDays()<7&&p.getDays()>=0)
        {
            switch (scop) {
                case "VACCIN":
                    sendNotification(scop,"In "+p.getDays()+ " zi/zile "
                            +a.getNumeAnimal()+" trebuie vaccinat/a!");
                    break;
                case "DEPARAZITARE":
                    sendNotification(scop,"In "+p.getDays()+ " zi/zile "
                            +a.getNumeAnimal()+" trebuie deparazitat/a!");
                    break;
                default:
                    break;
            }
        }
    }
}