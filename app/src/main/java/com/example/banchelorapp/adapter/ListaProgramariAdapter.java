package com.example.banchelorapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.banchelorapp.R;
import com.example.banchelorapp.utils.Programare;
import com.example.banchelorapp.utils.Salon;
import com.example.banchelorapp.utils.ServiciuSalon;

import java.util.ArrayList;
import java.util.List;

public class ListaProgramariAdapter extends ArrayAdapter<Programare> {
    private Context mContext;
    int mResource;

    public ListaProgramariAdapter(@NonNull Context context, int resource,
                               @NonNull ArrayList<Programare> objects){
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String numeAnimal=getItem(position).getNumeAnimalprogramat();
        String dataProgramare=getItem(position).getDataProgramare();
        String oraProgramare=getItem(position).getOraProgramare();
        String serviciu=getItem(position).getServiciu();
        String numeSalon=getItem(position).getNumeSalon();


        Programare programare=new Programare(dataProgramare,oraProgramare,numeAnimal,serviciu,numeSalon);

        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);

        TextView tvNumeAnimal=convertView.findViewById(R.id.tvNumeAnimalServicii);
        TextView tvNumeSalon=convertView.findViewById(R.id.tvNumeSalonServicii);
        TextView tv_ora=convertView.findViewById(R.id.tv_ora);
        TextView tv_serviciu=convertView.findViewById(R.id.tv_serviciu);
        TextView tvZi=convertView.findViewById(R.id.tvZi);

        tvNumeAnimal.setText("Nume animal: "+programare.getNumeAnimalprogramat());
        tvNumeSalon.setText("Nume salon: "+programare.getNumeSalon());
        tv_ora.setText("Ora programare: "+programare.getOraProgramare());
        tv_serviciu.setText(programare.getServiciu());
        tvZi.setText("Data programare: "+programare.getDataProgramare());
        return convertView;
    }
}
