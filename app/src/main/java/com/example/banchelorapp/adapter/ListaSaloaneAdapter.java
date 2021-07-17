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
import com.example.banchelorapp.utils.Salon;
import com.example.banchelorapp.utils.ServiciuSalon;

import java.util.ArrayList;
import java.util.List;

public class ListaSaloaneAdapter extends ArrayAdapter<Salon> {
    private Context mContext;
    int mResource;
    public ListaSaloaneAdapter(@NonNull Context context, int resource,
                               @NonNull ArrayList<Salon> objects){
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int codSalon=getItem(position).getCod();
        String numeSalon=getItem(position).getNumeSalon();
        String despre=getItem(position).getDespre();
        List<ServiciuSalon> servicii=getItem(position).getServicii();
        List<String> poze=getItem(position).getPozeSalon();
        String telefon=getItem(position).getTelefon();
        String site=getItem(position).getSite();
        String locatie=getItem(position).getLocatie();
        List<String> program=getItem(position).getProgram();

         //creez obiect Salon
        Salon salon=new Salon(codSalon,numeSalon,despre,servicii,poze,telefon,site,locatie,program);

        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);

        TextView tvNume=convertView.findViewById(R.id.tvNumeSalon);
        TextView tvLocatie=convertView.findViewById(R.id.tvLocatieSalon);

        tvNume.setText(salon.getNumeSalon());
        tvLocatie.setText(salon.getLocatie());

        return convertView;
    }
}
