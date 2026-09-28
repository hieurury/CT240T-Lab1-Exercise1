package source;

public class ElectronicProduct extends Product implements Discountable {

    public ElectronicProduct() {
    }

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    private int warrantyMonths;

    @Override
    public double calculateFinalPrice() {
        return this.getPrice() * 1.1;
    }

    @Override
    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            double newPrice = this.getPrice() * (1 - percent / 100);
            this.setPrice(newPrice);
        }
    }

}