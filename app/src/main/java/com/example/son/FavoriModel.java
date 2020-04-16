package com.example.son;

public class FavoriModel {

    private int productImage;
    private String productTitle;
    private String oylama;
    private int totalRatings;
    private String productFiyat;
    private String paymentMethod;

    public FavoriModel(int productImage, String productTitle, String oylama, int totalRatings, String productFiyat, String paymentMethod) {

        this.productImage = productImage;
        this.productTitle = productTitle;
        this.oylama = oylama;
        this.totalRatings = totalRatings;
        this.productFiyat = productFiyat;
        this.paymentMethod = paymentMethod;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getOylama() {
        return oylama;
    }

    public void setOylama(String oylama) {
        this.oylama = oylama;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getProductFiyat() {
        return productFiyat;
    }

    public void setProductFiyat(String productFiyat) {
        this.productFiyat = productFiyat;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
