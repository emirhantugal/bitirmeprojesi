package com.example.son;

public class ProductMenuModel {

    private String featureNam;
    private String feauteFiyat;

    public ProductMenuModel(String featureNam, String feauteFiyat) {
        this.featureNam = featureNam;
        this.feauteFiyat = feauteFiyat;
    }

    public String getFeatureNam() {
        return featureNam;
    }

    public void setFeatureNam(String featureNam) {
        this.featureNam = featureNam;
    }

    public String getFeauteFiyat() {
        return feauteFiyat;
    }

    public void setFeauteFiyat(String feauteFiyat) {
        this.feauteFiyat = feauteFiyat;
    }
}
