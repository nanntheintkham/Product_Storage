package Model;

public class Gloves extends Product {
    private final String size;

    public Gloves(double price, int numberOfItems, String size) {
        super(price, numberOfItems);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + ", Size: " + size + "}";
    }
}
