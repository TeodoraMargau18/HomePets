package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Proprietar implements Parcelable {
//        nume, prenume, mail, adresa, numar Tel, parola
    private String nume;
    private String prenume;
    private String adresa;
    private String id;
    private String numarTel;
    private String parola;
    private ArrayList<Animal> listaAnimale;

    public Proprietar(String nume, String prenume, String adresa, String id, String numarTel, String parola, ArrayList<Animal> listaAnimale) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.id = id;
        this.numarTel = numarTel;
        this.parola = parola;
        this.listaAnimale = listaAnimale;
    }

    protected Proprietar(Parcel in) {
        nume = in.readString();
        prenume = in.readString();
        adresa = in.readString();
        id = in.readString();
        numarTel = in.readString();
        parola = in.readString();
        listaAnimale = in.createTypedArrayList(Animal.CREATOR);
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(prenume);
        dest.writeString(adresa);
        dest.writeString(id);
        dest.writeString(numarTel);
        dest.writeString(parola);
        dest.writeTypedList(listaAnimale);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Proprietar> CREATOR = new Creator<Proprietar>() {
        @Override
        public Proprietar createFromParcel(Parcel in) {
            return new Proprietar(in);
        }

        @Override
        public Proprietar[] newArray(int size) {
            return new Proprietar[size];
        }
    };

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumarTel() {
        return numarTel;
    }

    public void setNumarTel(String numarTel) {
        this.numarTel = numarTel;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public ArrayList<Animal> getListaAnimale() {
        return listaAnimale;
    }

    public void setListaAnimale(ArrayList<Animal> listaAnimale) {
        this.listaAnimale = listaAnimale;
    }

    @Override
    public String toString() {
        return "Proprietar{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", id='" + id + '\'' +
                ", numarTel='" + numarTel + '\'' +
                ", parola='" + parola + '\'' +
                ", listaAnimale=" + listaAnimale +
                '}';
    }
}
