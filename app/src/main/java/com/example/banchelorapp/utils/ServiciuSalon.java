package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class ServiciuSalon implements Parcelable {
    private String categorieAnimal;
    private String denumireServiciu;
    private float tarifServiciu;

    public ServiciuSalon(String denumireServiciu, float tarifServiciu, String categorieAnimal) {
        this.denumireServiciu = denumireServiciu;
        this.tarifServiciu = tarifServiciu;
        this.categorieAnimal=categorieAnimal;
    }

    protected ServiciuSalon(Parcel in) {
        categorieAnimal = in.readString();
        denumireServiciu = in.readString();
        tarifServiciu = in.readFloat();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categorieAnimal);
        dest.writeString(denumireServiciu);
        dest.writeFloat(tarifServiciu);
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

    public String getCategorieAnimal() {
        return categorieAnimal;
    }

    public void setCategorieAnimal(String categorieAnimal) {
        this.categorieAnimal = categorieAnimal;
    }

}
