package com.example.meri_zameen;

public class dataHolder {
    private Double EC;
    private Boolean Flag;
    private Double Humidity;
    private Double K;
    private Double N;
    private Double P;
    private Double Temperature;
    private Double pH;

    public dataHolder(Double EC, Boolean flag, Double humidity, Double k, Double n, Double p, Double temperature, Double pH) {
        this.EC = EC;
        Flag = flag;
        Humidity = humidity;
        K = k;
        N = n;
        P = p;
        Temperature = temperature;
        this.pH = pH;
    }
    public dataHolder(){

    }

    public Double getEC() {
        return EC;
    }

    public void setEC(Double EC) {
        this.EC = EC;
    }

    public Boolean getFlag() {
        return Flag;
    }

    public void setFlag(Boolean flag) {
        Flag = flag;
    }

    public Double getHumidity() {
        return Humidity;
    }

    public void setHumidity(Double humidity) {
        Humidity = humidity;
    }

    public Double getK() {
        return K;
    }

    public void setK(Double k) {
        K = k;
    }

    public Double getN() {
        return N;
    }

    public void setN(Double n) {
        N = n;
    }

    public Double getP() {
        return P;
    }

    public void setP(Double p) {
        P = p;
    }

    public Double getTemperature() {
        return Temperature;
    }

    public void setTemperature(Double temperature) {
        Temperature = temperature;
    }

    public Double getpH() {
        return pH;
    }

    public void setpH(Double pH) {
        this.pH = pH;
    }

}