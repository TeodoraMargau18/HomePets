package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.banchelorapp.Calculeaza;

import java.util.ArrayList;

public class Salon implements Parcelable, Calculeaza {

    private String numeSalon;
    private String despre;
    private ArrayList<ServiciuSalon> servicii;//Fac clasa ServiciuSalon cu denumireServiciu si tarifServiciu
    private String telefon;
    private String site;
    private String locatie;
    private ArrayList<String> program;//O sa am fie l-v 08:00-17:00 , sambata 09:12 fie tot orarul intr-un String
    //Adauga o lista de programari

    public Salon(String numeSalon,String despre, ArrayList<ServiciuSalon> servicii, String telefon, String site, String locatie, ArrayList<String> program) {
       this.numeSalon=numeSalon;
        this.despre = despre;
        this.servicii = servicii;
        this.telefon = telefon;
        this.site = site;
        this.locatie = locatie;
        this.program = program;
    }


    protected Salon(Parcel in) {
        numeSalon = in.readString();
        despre = in.readString();
        servicii = in.createTypedArrayList(ServiciuSalon.CREATOR);
        telefon = in.readString();
        site = in.readString();
        locatie = in.readString();
        program = in.createStringArrayList();
    }

    public static final Creator<Salon> CREATOR = new Creator<Salon>() {
        @Override
        public Salon createFromParcel(Parcel in) {
            return new Salon(in);
        }

        @Override
        public Salon[] newArray(int size) {
            return new Salon[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numeSalon);
        dest.writeString(despre);
        dest.writeTypedList(servicii);
        dest.writeString(telefon);
        dest.writeString(site);
        dest.writeString(locatie);
        dest.writeStringList(program);
    }

    public String getNumeSalon() {
        return numeSalon;
    }

    public void setNumeSalon(String numeSalon) {
        this.numeSalon = numeSalon;
    }

    public String getDespre() {
        return despre;
    }

    public void setDespre(String despre) {
        this.despre = despre;
    }

    public ArrayList<ServiciuSalon> getServicii() {
        return servicii;
    }

    public void setServicii(ArrayList<ServiciuSalon> servicii) {
        this.servicii = servicii;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public ArrayList<String> getProgram() {
        return program;
    }

    public void setProgram(ArrayList<String> program) {
        this.program = program;
    }


    @Override
    public float calculeazaSumaTotala() {
        float sum=0;
        if(servicii!=null){
            for(ServiciuSalon serviciu : servicii){
                sum+=serviciu.getTarifServiciu();
            }
        }
        return sum;
    }

    @Override
    public float calculeazaTimpTotal() {
        float timpTotal=0;
        if(servicii!=null){
            for(ServiciuSalon serviciu : servicii){
                timpTotal+=serviciu.getDurata();
            }
        }
        return timpTotal;
    }
}