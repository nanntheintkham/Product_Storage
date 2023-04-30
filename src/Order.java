import Model.*;

public class Order {
    private String itemType;
    private double price;
    private int numPieces;
    private String attribute;
    private String customerName;
    private String office;

    public Order(String itemType, double price, int numPieces, String attribute, String customerName, String office) {
        this.itemType = itemType;
        this.price = price;
        this.numPieces = numPieces;
        this.attribute = attribute;
        this.customerName = customerName;
        this.office = office;
    }


    public String getItemType() {
        return itemType;
    }

    public double getPrice() {
        return price;
    }

    public int getNumPieces() {
        return numPieces;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOffice() {
        return office;
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemType='" + itemType + '\'' +
                ", price=" + price +
                ", numPieces=" + numPieces +
                ", attribute='" + attribute + '\'' +
                '}';
    }
}
