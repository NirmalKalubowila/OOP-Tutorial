package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct(){}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }


    //The @Override annotation helps the compiler catch mistakes
    // such as typos or incorrect method signatures, ensuring that the method actually overrides a method from the parent class.
    @Override
    public String getSummary(){
        return getName() + " - $"+ getPrice()+ " | wight: " + this.weightKg+"kg";
    }


    //Both classes compile because the interface defines what methods they must have, but each class can write its own code for those methods.
    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
