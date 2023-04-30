package Model;

public class Notebook extends Product{
    private final int pages;

    public Notebook(double price, int numberOfPieces, int pages) {
        super(price, numberOfPieces);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return  super.toString() + ", number of pages: " + pages + "}";
    }
}
