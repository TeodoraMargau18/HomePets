package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.banchelorapp.Calculeaza;

import java.util.List;

public class Salon implements Parcelable, Calculeaza {

    private int cod;
    private String numeSalon;
    private String despre;
    private List<ServiciuSalon> servicii;
    private List<String> pozeSalon;
    private String telefon;
    private String site;
    private String locatie;
    private List<String> program;
    //Adauga o lista de programari


    public Salon(int cod, String numeSalon, String despre, List<ServiciuSalon> servicii, List<String> pozeSalon, String telefon, String site, String locatie, List<String> program) {
        this.cod = cod;
        this.numeSalon = numeSalon;
        this.despre = despre;
        this.servicii = servicii;
        this.pozeSalon = pozeSalon;
        this.telefon = telefon;
        this.site = site;
        this.locatie = locatie;
        this.program = program;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    public List<ServiciuSalon> getServicii() {
        return servicii;
    }

    public void setServicii(List<ServiciuSalon> servicii) {
        this.servicii = servicii;
    }

    public List<String> getPozeSalon() {
        return pozeSalon;
    }

    public void setPozeSalon(List<String> pozeSalon) {
        this.pozeSalon = pozeSalon;
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

    public List<String> getProgram() {
        return program;
    }

    public void setProgram(List<String> program) {
        this.program = program;
    }

    protected Salon(Parcel in) {
        cod = in.readInt();
        numeSalon = in.readString();
        despre = in.readString();
        servicii = in.createTypedArrayList(ServiciuSalon.CREATOR);
        pozeSalon = in.createStringArrayList();
        telefon = in.readString();
        site = in.readString();
        locatie = in.readString();
        program = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cod);
        dest.writeString(numeSalon);
        dest.writeString(despre);
        dest.writeTypedList(servicii);
        dest.writeStringList(pozeSalon);
        dest.writeString(telefon);
        dest.writeString(site);
        dest.writeString(locatie);
        dest.writeStringList(program);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public void adaugaServiciu(ServiciuSalon serviciu) {
       this.servicii.add(serviciu);
    }
    public void adaugaPoza(String poza) {this.pozeSalon.add(poza); }


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