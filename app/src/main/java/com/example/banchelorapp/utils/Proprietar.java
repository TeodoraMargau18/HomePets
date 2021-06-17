package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Proprietar implements Parcelable {
//        nume, prenume, mail, adresa, numar Tel, parola
    private String nume;
    private String prenume;
    private String adresa;
    private String email;
    private String numarTel;
    private String parola;
    private ArrayList<Animal> listaAnimale;

    public Proprietar() {
        this.nume = "";
        this.prenume = "";
        this.adresa = "";
        this.email = "";
        this.numarTel = "";
        this.parola = "";
        this.listaAnimale = new ArrayList<>();
    }

    public Proprietar(String nume, String prenume, String adresa, String email, String numarTel, String parola, ArrayList<Animal> listaAnimale) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.email = email;
        this.numarTel = numarTel;
        this.parola = parola;
        this.listaAnimale = listaAnimale;
    }

    protected Proprietar(Parcel in) {
        nume = in.readString();
        prenume = in.readString();
        adresa = in.readString();
        email = in.readString();
        numarTel = in.readString();
        parola = in.readString();
        listaAnimale = in.createTypedArrayList(Animal.CREATOR);
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(prenume);
        dest.writeString(adresa);
        dest.writeString(email);
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


    public String getPrenume() {
        return prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumarTel() {
        return numarTel;
    }


    @Override
    public String toString() {
        return "Proprietar{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", id='" + email + '\'' +
                ", numarTel='" + numarTel + '\'' +
                ", parola='" + parola + '\'' +
                ", listaAnimale=" + listaAnimale +
                '}';
    }
}
