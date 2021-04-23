package com.example.banchelorapp.utils.interventii;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Interventie implements Parcelable {
    private String tipInterventie;
    private Date dataInterventie;
    private String medic;
    private float tarif;
    private String codInterventie;
    private String cipAnimal;

    public Interventie(String tipInterventie, Date dataInterventie, String medic, float tarif, String codInterventie, String cipAnimal) {
        this.tipInterventie = tipInterventie;
        this.dataInterventie = dataInterventie;
        this.medic = medic;
        this.tarif = tarif;
        this.codInterventie = codInterventie;
        this.cipAnimal = cipAnimal;
    }

    protected Interventie(Parcel in) {
        tipInterventie = in.readString();
        medic = in.readString();
        tarif = in.readFloat();
        codInterventie = in.readString();
        cipAnimal = in.readString();
        dataInterventie =(Date) in.readSerializable();
    }

    public static final Creator<Interventie> CREATOR = new Creator<Interventie>() {
        @Override
        public Interventie createFromParcel(Parcel in) {
            return new Interventie(in);
        }

        @Override
        public Interventie[] newArray(int size) {
            return new Interventie[size];
        }
    };

    public String getTipInterventie() {
        return tipInterventie;
    }

    public void setTipInterventie(String tipInterventie) {
        this.tipInterventie = tipInterventie;
    }

    public Date getDataInterventie() {
        return dataInterventie;
    }

    public void setDataInterventie(Date dataInterventie) {
        this.dataInterventie = dataInterventie;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public String getCodInterventie() {
        return codInterventie;
    }

    public void setCodInterventie(String codInterventie) {
        this.codInterventie = codInterventie;
    }

    public String getCipAnimal() {
        return cipAnimal;
    }

    public void setCipAnimal(String cipAnimal) {
        this.cipAnimal = cipAnimal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tipInterventie);
        dest.writeString(medic);
        dest.writeFloat(tarif);
        dest.writeString(codInterventie);
        dest.writeString(cipAnimal);
        dest.writeSerializable(dataInterventie);
    }

    @Override
    public String toString() {
        return "Interventie{" +
                "tipInterventie='" + tipInterventie + '\'' +
                ", dataInterventie=" + dataInterventie +
                ", medic='" + medic + '\'' +
                ", tarif=" + tarif +
                ", codInterventie='" + codInterventie + '\'' +
                ", cipAnimal='" + cipAnimal + '\'' +
                '}';
    }
}
