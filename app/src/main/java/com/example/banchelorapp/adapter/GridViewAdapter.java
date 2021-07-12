package com.example.banchelorapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banchelorapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> numeAnimale;
    private List<String> pozeAnimale;

    public GridViewAdapter(Context context, List<String> numeAnimale, List<String> pozeAnimale) {
        this.context = context;
        this.numeAnimale = numeAnimale;
        this.pozeAnimale = pozeAnimale;
    }

    @Override
    public int getCount() {
        return numeAnimale.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(layoutInflater==null){
            layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.row_item,null);
        }
        ImageView imageView=convertView.findViewById(R.id.ivAnimalAdoptie);
        TextView textView=convertView.findViewById(R.id.tvNumeAnimalAdoptie);
        Picasso.get().load(pozeAnimale.get(position).trim()).into(imageView);
        textView.setText(numeAnimale.get(position));
        return convertView;
    }
    public void updateItems(List<String> newNumeAnimale, List<String> newPozeAnimale) {
        this.numeAnimale = newNumeAnimale;
        this.pozeAnimale = newPozeAnimale;
        notifyDataSetChanged();
    }
}
