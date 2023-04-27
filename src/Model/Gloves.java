package Model;

public class Gloves extends Equipment {
    private final String size;

    public Gloves(int safetyLevel, int numberOfItems, String size) {
        super(safetyLevel, numberOfItems);
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
