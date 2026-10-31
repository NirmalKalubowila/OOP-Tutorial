package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable{
    private String downloadUrl;
    private Double fileSizeMB;
    private double discountedPrice;

    public DigitalProduct(){}

    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public String getSummary(){
        return getName() + " - $"+ getPrice()+ " | Download: " + downloadUrl;
    }

    @Override
    public void applyDiscount(double rate) {
        discountedPrice = getPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
