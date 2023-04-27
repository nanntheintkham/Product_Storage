package Model;

public class Mask extends Equipment {
    private final String attachmentType;

    public Mask(int safetyLevel, int numberOfItems, String attachmentType) {
        super(safetyLevel, numberOfItems);
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
