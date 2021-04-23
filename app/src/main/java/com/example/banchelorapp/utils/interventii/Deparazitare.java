package com.example.banchelorapp.utils.interventii;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Deparazitare implements Parcelable {
    private Date dataDeparazitare;
    private Date dataViitoareiDeparazitari;
    private String tipDeparazitare;
    private String produsDeparazitare;
    private float pretProdus;
    private String cipAnimal;

    public Deparazitare(Date dataDeparazitare, Date dataViitoareiDeparazitari, String tipDeparazitare, String produsDeparazitare, float pretProdus, String cipAnimal) {
        this.dataDeparazitare = dataDeparazitare;
        this.dataViitoareiDeparazitari = dataViitoareiDeparazitari;
        this.tipDeparazitare = tipDeparazitare;
        this.produsDeparazitare = produsDeparazitare;
        this.pretProdus = pretProdus;
        this.cipAnimal = cipAnimal;
    }

    protected Deparazitare(Parcel in) {
        tipDeparazitare = in.readString();
        produsDeparazitare = in.readString();
        pretProdus = in.readFloat();
        cipAnimal = in.readString();
        dataDeparazitare =(Date) in.readSerializable();
        dataViitoareiDeparazitari =(Date) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tipDeparazitare);
        dest.writeString(produsDeparazitare);
        dest.writeFloat(pretProdus);
        dest.writeString(cipAnimal);
        dest.writeSerializable(dataDeparazitare);
        dest.writeSerializable(dataViitoareiDeparazitari);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Deparazitare> CREATOR = new Creator<Deparazitare>() {
        @Override
        public Deparazitare createFromParcel(Parcel in) {
            return new Deparazitare(in);
        }

        @Override
        public Deparazitare[] newArray(int size) {
            return new Deparazitare[size];
        }
    };

    public Date getDataDeparazitare() {
        return dataDeparazitare;
    }

    public void setDataDeparazitare(Date dataDeparazitare) {
        this.dataDeparazitare = dataDeparazitare;
    }

    public Date getDataViitoareiDeparazitari() {
        return dataViitoareiDeparazitari;
    }

    public void setDataViitoareiDeparazitari(Date dataViitoareiDeparazitari) {
        this.dataViitoareiDeparazitari = dataViitoareiDeparazitari;
    }

    public String getTipDeparazitare() {
        return tipDeparazitare;
    }

    public void setTipDeparazitare(String tipDeparazitare) {
        this.tipDeparazitare = tipDeparazitare;
    }

    public String getProdusDeparazitare() {
        return produsDeparazitare;
    }

    public void setProdusDeparazitare(String produsDeparazitare) {
        this.produsDeparazitare = produsDeparazitare;
    }

    public float getPretProdus() {
        return pretProdus;
    }

    public void setPretProdus(float pretProdus) {
        this.pretProdus = pretProdus;
    }

    public String getCipAnimal() {
        return cipAnimal;
    }

    public void setCipAnimal(String cipAnimal) {
        this.cipAnimal = cipAnimal;
    }

    @Override
    public String toString() {
        return "Deparazitare{" +
                "dataDeparazitare=" + dataDeparazitare +
                ", dataViitoareiDeparazitari=" + dataViitoareiDeparazitari +
                ", tipDeparazitare='" + tipDeparazitare + '\'' +
                ", produsDeparazitare='" + produsDeparazitare + '\'' +
                ", pretProdus=" + pretProdus +
                ", cipAnimal='" + cipAnimal + '\'' +
                '}';
    }
}
