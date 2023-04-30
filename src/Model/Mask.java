package Model;

public class Mask extends Product {
    private final String attachmentType;

    public Mask(double price, int numberOfItems, String attachmentType) {
        super(price, numberOfItems);
        this.attachmentType = attachmentType;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    @Override
    public String toString() {
        return super.toString() + ", attachment type: " + attachmentType + "}";
    }


}
