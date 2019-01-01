package com.example.arlinda.nbaretrofit.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class League {
    public ArrayList<Standard> getStandard() {
        return standard;
    }

    public void setStandard(ArrayList<Standard> standard) {
        this.standard = standard;
    }

    public ArrayList<Africa> getAfricca() {
        return africca;
    }

    public void setAfricca(ArrayList<Africa> africca) {
        this.africca = africca;
    }

    public ArrayList<Sacramento> getSacramento() {
        return sacramento;
    }

    public void setSacramento(ArrayList<Sacramento> sacramento) {
        this.sacramento = sacramento;
    }

    public ArrayList<Vegas> getVegas() {
        return vegas;
    }

    public void setVegas(ArrayList<Vegas> vegas) {
        this.vegas = vegas;
    }

    public ArrayList<Utah> getUtah() {
        return utah;
    }

    public void setUtah(ArrayList<Utah> utah) {
        this.utah = utah;
    }

    @Override
    public String toString() {
        return "League{" +
                "standard=" + standard +
                ", africca=" + africca +
                ", sacramento=" + sacramento +
                ", vegas=" + vegas +
                ", utah=" + utah +
                '}';
    }

    @SerializedName("standard")
    @Expose
    private ArrayList<Standard> standard;

    @SerializedName("africa")
    @Expose
    private ArrayList<Africa> africca;

    @SerializedName("sacramento")
    @Expose
    private ArrayList<Sacramento> sacramento;

    @SerializedName("vegas")
    @Expose
    private ArrayList<Vegas> vegas;

    @SerializedName("utah")
    @Expose
    private ArrayList<Utah> utah;
}
