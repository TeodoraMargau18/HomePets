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

    public Vaccin(String tip, Date dataVaccin, Date dataViitoareiVaccinări, String medic,float pretVaccin) {
        this.tip = tip;
        this.dataVaccin = dataVaccin;
        this.dataViitoareiVaccinări = dataViitoareiVaccinări;
        this.medic = medic;
        this.pretVaccin = pretVaccin;
    }

    protected Vaccin(Parcel in) {
        tip = in.readString();
        medic = in.readString();
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

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    public Date getDataViitoareiVaccinări() {
        return dataViitoareiVaccinări;
    }

    public void setDataViitoareiVaccinări(Date dataViitoareiVaccinări) {
        this.dataViitoareiVaccinări = dataViitoareiVaccinări;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public float getPretVaccin() {
        return pretVaccin;
    }

    public void setPretVaccin(float pretVaccin) {
        this.pretVaccin = pretVaccin;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tip);
        dest.writeString(medic);
    }
}
