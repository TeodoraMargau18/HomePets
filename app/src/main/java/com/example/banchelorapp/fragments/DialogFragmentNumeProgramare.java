package com.example.banchelorapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.banchelorapp.AnimaleleMeleActivity;
import com.example.banchelorapp.AuthentificationActivity;
import com.example.banchelorapp.MainActivity;
import com.example.banchelorapp.R;
import com.example.banchelorapp.booking.SalonBookingActivity;
import com.example.banchelorapp.mysql.BackgroundTask;
import com.example.banchelorapp.utils.Animal;
import com.squareup.picasso.Picasso;

public class DialogFragmentNumeProgramare extends DialogFragment {

    EditText etNume;
    Button btnTrimite;
    DialogFragmentNumeProgramare dlg;
    String numeAnimal,ora,codServiciu,dataInsert;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dialog_fragment_nume_programare, container, false);
        etNume = view.findViewById(R.id.etNume);
        btnTrimite = view.findViewById(R.id.btnTrimite);
        dlg=this;
        ora= (String) getArguments().getSerializable(
                SalonBookingActivity.ORA);
        codServiciu= (String) getArguments().getSerializable(
                SalonBookingActivity.COD_SERVICIU);
        dataInsert= (String) getArguments().getSerializable(
                SalonBookingActivity.DATA_INSERT);
        btnTrimite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type="inserareProgramare";
                numeAnimal = etNume.getText().toString();

                SalonBookingActivity.inserat=true;
                BackgroundTask backgroundTask=new BackgroundTask(SalonBookingActivity.ctx);
                backgroundTask.execute(type,ora,numeAnimal,codServiciu,dataInsert, AuthentificationActivity.email);
                    Toast.makeText(view.getContext(),
                            "S-a realizat programarea pentru "+numeAnimal+".", Toast.LENGTH_LONG)
                            .show();
                dlg.dismiss();
                SalonBookingActivity.currentApp.finish();
            }
        });
        return view;
    }

}