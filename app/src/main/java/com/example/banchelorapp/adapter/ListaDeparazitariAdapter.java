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
import com.example.banchelorapp.utils.interventii.Deparazitare;

import java.util.ArrayList;
import java.util.Date;

public class ListaDeparazitariAdapter extends ArrayAdapter<Deparazitare> {
    private static final String TAG="ListaDeparazitariAdapter";
    private Context mContext;
    int mResource;

    public ListaDeparazitariAdapter(@NonNull Context context, int resource,
                                    @NonNull ArrayList<Deparazitare> objects){
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String tipDeparazitare=getItem(position).getTipDeparazitare();
        String produsDeparazitare=getItem(position).getProdusDeparazitare();
        Date dataDeparazitare=getItem(position).getDataDeparazitare();
        Date dataViitoareiDeparazitari=getItem(position).getDataViitoareiDeparazitari();

      Deparazitare deparazitare=new Deparazitare(dataDeparazitare,dataViitoareiDeparazitari,tipDeparazitare,produsDeparazitare);
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);

        TextView tvDataDeparazitare=convertView.findViewById(R.id.tvDataDeparazitare);
        TextView tvTipDeparazitare=convertView.findViewById(R.id.tipDeparazitare);
        TextView tvProdusDeparazitare=convertView.findViewById(R.id.tvDenumireProdus);

        tvDataDeparazitare.setText("Data deparazitare:"+deparazitare.getDataDeparazitare()+
                " - Data viitoarei deparazitari: "+deparazitare.getDataDeparazitare());
        tvTipDeparazitare.setText("Tipul deparazitarii : "+deparazitare.getTipDeparazitare());
        tvProdusDeparazitare.setText("Deparazitat cu "+deparazitare.getProdusDeparazitare());

        return convertView;
    }
}
