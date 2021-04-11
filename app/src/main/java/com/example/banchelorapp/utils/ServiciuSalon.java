package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class ServiciuSalon implements Parcelable {
    private String categorieAnimal;
    private String denumireServiciu;
    private float tarifServiciu;
    private float durata;
    private int codSalon;

    public ServiciuSalon(String categorieAnimal, String denumireServiciu, float tarifServiciu, float durata, int codSalon) {
        this.categorieAnimal = categorieAnimal;
        this.denumireServiciu = denumireServiciu;
        this.tarifServiciu = tarifServiciu;
        this.durata = durata;
        this.codSalon = codSalon;
    }

    protected ServiciuSalon(Parcel in) {
        categorieAnimal = in.readString();
        denumireServiciu = in.readString();
        tarifServiciu = in.readFloat();
        durata = in.readFloat();
        codSalon = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categorieAnimal);
        dest.writeString(denumireServiciu);
        dest.writeFloat(tarifServiciu);
        dest.writeFloat(durata);
        dest.writeInt(codSalon);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ServiciuSalon> CREATOR = new Creator<ServiciuSalon>() {
        @Override
        public ServiciuSalon createFromParcel(Parcel in) {
            return new ServiciuSalon(in);
        }

        @Override
        public ServiciuSalon[] newArray(int size) {
            return new ServiciuSalon[size];
        }
    };

    public String getCategorieAnimal() {
        return categorieAnimal;
    }

    public void setCategorieAnimal(String categorieAnimal) {
        this.categorieAnimal = categorieAnimal;
    }

    public String getDenumireServiciu() {
        return denumireServiciu;
    }

    public void setDenumireServiciu(String denumireServiciu) {
        this.denumireServiciu = denumireServiciu;
    }

    public float getTarifServiciu() {
        return tarifServiciu;
    }

    public void setTarifServiciu(float tarifServiciu) {
        this.tarifServiciu = tarifServiciu;
    }

    public float getDurata() {
        return durata;
    }

    public void setDurata(float durata) {
        this.durata = durata;
    }

    public int getCodSalon() {
        return codSalon;
    }

    public void setCodSalon(int codSalon) {
        this.codSalon = codSalon;
    }
}
