package Model;

public abstract class Product implements Comparable<Product>{
    private final double price;
    private double numberOfPieces;

    public Product(double price, int numberOfPieces){
        this.price = price;
        this.numberOfPieces = numberOfPieces;
    }


    public double getPrice(){
        return price;
    }

    public double getNumberOfPieces() {
        return numberOfPieces;
    }

    @Override
    public int compareTo(Product o) {
        return (int) (price - o.price);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {price: " + price + ", number of Pieces: " + numberOfPieces;
    }


}
