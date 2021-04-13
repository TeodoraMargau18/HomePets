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
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
import java.util.Date;

public class ListaVaccinuriAdapter extends ArrayAdapter<Vaccin> {
    private static final String TAG="ListaVaccinuriAdapter";
    private Context mContext;
    int mResource;

    public ListaVaccinuriAdapter(@NonNull Context context, int resource,
                               @NonNull ArrayList<Vaccin> objects){
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String tipVaccin=getItem(position).getTip();
        String medic=getItem(position).getMedic();
        Date dataVaccin=getItem(position).getDataVaccin();
        Date dataViitoareiVaccinari=getItem(position).getDataViitoareiVaccinări();
        float pret=getItem(position).getPretVaccin();

      Vaccin vaccin=new Vaccin(tipVaccin,dataVaccin,dataViitoareiVaccinari,medic,pret);
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);

        TextView tvDataVaccin=convertView.findViewById(R.id.tvDataVaccin);
        TextView tvMedic=convertView.findViewById(R.id.tvNumeMedic);
        TextView tvTip=convertView.findViewById(R.id.tvNumeVaccin);

        tvDataVaccin.setText("Data vaccin:"+vaccin.getDataVaccin()+ " - Data viitorului vaccin: "+vaccin.getDataViitoareiVaccinări());
        tvMedic.setText("Medic "+vaccin.getMedic());
        tvTip.setText("Tip vaccin: "+vaccin.getTip());

        return convertView;
    }
}
