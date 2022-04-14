package com.example.meri_zameen;

public class SavedValuesModel {
    private String EC;
    private String Humidity;
    private String K;
    private String N;
    private String P;
    private String Temperature;
    private String pH;
    private String Time;
    private String sampleID;
    SavedValuesModel(){

    }

    public SavedValuesModel(String EC, String humidity, String k, String n, String p, String temperature, String pH, String time, String sampleID) {
        this.EC = EC;
        Humidity = humidity;
        K = k;
        N = n;
        P = p;
        Temperature = temperature;
        this.pH = pH;
        this.Time = time;
        this.sampleID = sampleID;
    }

    public String getSampleID() {
        return sampleID;
    }

    public void setSampleID(String sampleID) {
        this.sampleID = sampleID;
    }

    public String getEC() {
        return EC;
    }

    public void setEC(String EC) {
        this.EC = EC;
    }

    public String getHumidity() {
        return Humidity;
    }

    public void setHumidity(String humidity) {
        Humidity = humidity;
    }

    public String getK() {
        return K;
    }

    public void setK(String k) {
        K = k;
    }

    public String getN() {
        return N;
    }

    public void setN(String n) {
        N = n;
    }

    public String getP() {
        return P;
    }

    public void setP(String p) {
        P = p;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public String getpH() {
        return pH;
    }

    public void setpH(String pH) {
        this.pH = pH;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        this.Time = time;
    }
}
