package com.example.son;

public class HorizantalProductScrollModel {

    private int produceImage;
    private String productTitle;
    private String productDescription;
    private String productAlkol;

    public HorizantalProductScrollModel(int produceImage, String productTitle, String productDescription, String productAlkol) {
        this.produceImage = produceImage;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productAlkol = productAlkol;
    }

    public int getProduceImage() {
        return produceImage;
    }

    public void setProduceImage(int produceImage) {
        this.produceImage = produceImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductAlkol() {
        return productAlkol;
    }

    public void setProductAlkol(String productAlkol) {
        this.productAlkol = productAlkol;
    }
}
