package Model;

public class Pencil extends Product{
    private final String color;

    public Pencil(double price, int numberOfPieces, String color) {
        super(price, numberOfPieces);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + ", Color: " + color + "}";
    }
}
