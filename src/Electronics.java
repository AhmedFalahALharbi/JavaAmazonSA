public class Electronics extends Product {
    private int warrantyMonths;

    public Electronics(int productID, String name, double price, int stockQuantity, int warrantyMonths) {
        super(productID, name, "Electronics", price, stockQuantity);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", warrantyMonths=" + warrantyMonths +
                '}';
    }
}
