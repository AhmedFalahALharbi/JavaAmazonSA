public class Clothing extends Product {
    private String size;

    public Clothing(int productID, String name, double price, int stockQuantity, String size) {
        super(productID, name, "Clothing", price, stockQuantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.15;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", size='" + size + '\'' +
                '}';
    }
}
