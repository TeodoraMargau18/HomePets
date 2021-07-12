package com.example.banchelorapp.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class ProgramareSalon implements Parcelable {
    private int idProgramare;
    private String oraProgramare;
    private String cipAnimal;
    private int codSErviciu;
    private int codSalon;

    public ProgramareSalon(int idProgramare, String oraProgramare, String cipAnimal, int codSErviciu, int codSalon) {
        this.idProgramare = idProgramare;
        this.oraProgramare = oraProgramare;
        this.cipAnimal = cipAnimal;
        this.codSErviciu = codSErviciu;
        this.codSalon = codSalon;
    }
//Parcelable
    protected ProgramareSalon(Parcel in) {
        idProgramare = in.readInt();
        oraProgramare = in.readString();
        cipAnimal = in.readString();
        codSErviciu = in.readInt();
        codSalon = in.readInt();
    }

    public static final Creator<ProgramareSalon> CREATOR = new Creator<ProgramareSalon>() {
        @Override
        public ProgramareSalon createFromParcel(Parcel in) {
            return new ProgramareSalon(in);
        }

        @Override
        public ProgramareSalon[] newArray(int size) {
            return new ProgramareSalon[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idProgramare);
        dest.writeString(oraProgramare);
        dest.writeString(cipAnimal);
        dest.writeInt(codSErviciu);
        dest.writeInt(codSalon);
    }
//finish Parcelable
    public int getIdProgramare() {
        return idProgramare;
    }

    public void setIdProgramare(int idProgramare) {
        this.idProgramare = idProgramare;
    }

    public String getOraProgramare() {
        return oraProgramare;
    }

    public void setOraProgramare(String oraProgramare) {
        this.oraProgramare = oraProgramare;
    }

    public String getCipAnimal() {
        return cipAnimal;
    }

    public void setCipAnimal(String cipAnimal) {
        this.cipAnimal = cipAnimal;
    }

    public int getCodSErviciu() {
        return codSErviciu;
    }

    public void setCodSErviciu(int codSErviciu) {
        this.codSErviciu = codSErviciu;
    }

    public int getCodSalon() {
        return codSalon;
    }

    public void setCodSalon(int codSalon) {
        this.codSalon = codSalon;
    }
}
