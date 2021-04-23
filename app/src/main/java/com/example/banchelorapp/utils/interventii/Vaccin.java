package com.example.banchelorapp.utils.interventii;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Vaccin implements Parcelable {
    private String tip;
    private Date dataVaccin;
    private Date dataViitoareiVaccinări;
    private String medic;
    private float pretVaccin;
    private String cipAnimal;

    public Vaccin(String tip, Date dataVaccin, Date dataViitoareiVaccinări, String medic, float pretVaccin, String cipAnimal) {
        this.tip = tip;
        this.dataVaccin = dataVaccin;
        this.dataViitoareiVaccinări = dataViitoareiVaccinări;
        this.medic = medic;
        this.pretVaccin = pretVaccin;
        this.cipAnimal = cipAnimal;
    }

    protected Vaccin(Parcel in) {
        tip = in.readString();
        medic = in.readString();
        pretVaccin = in.readFloat();
        cipAnimal = in.readString();
        dataVaccin=(Date) in.readSerializable();
        dataViitoareiVaccinări=(Date) in.readSerializable();
    }

    public static final Creator<Vaccin> CREATOR = new Creator<Vaccin>() {
        @Override
        public Vaccin createFromParcel(Parcel in) {
            return new Vaccin(in);
        }

        @Override
        public Vaccin[] newArray(int size) {
            return new Vaccin[size];
        }
    };

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getDataVaccin() {
        return dataVaccin;
    }

    public void setDataVaccin(Date dataVaccin) {
        this.dataVaccin = dataVaccin;
    }

    public Date getDataViitoareiVaccinări() {
        return dataViitoareiVaccinări;
    }

    public void setDataViitoareiVaccinări(Date dataViitoareiVaccinări) {
        this.dataViitoareiVaccinări = dataViitoareiVaccinări;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    public float getPretVaccin() {
        return pretVaccin;
    }

    public void setPretVaccin(float pretVaccin) {
        this.pretVaccin = pretVaccin;
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
        dest.writeString(tip);
        dest.writeString(medic);
        dest.writeFloat(pretVaccin);
        dest.writeString(cipAnimal);
        dest.writeSerializable(dataVaccin);
        dest.writeSerializable(dataViitoareiVaccinări);
    }

    @Override
    public String toString() {
        return "Vaccin{" +
                "tip='" + tip + '\'' +
                ", dataVaccin=" + dataVaccin +
                ", dataViitoareiVaccinări=" + dataViitoareiVaccinări +
                ", medic='" + medic + '\'' +
                ", pretVaccin=" + pretVaccin +
                ", cipAnimal='" + cipAnimal + '\'' +
                '}';
    }
}
