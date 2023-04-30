package Model;

import java.util.ArrayList;
import java.util.Comparator;

public class MaskContainer extends Storage<Mask>{

    public MaskContainer(int Maxsize) {
        super(Maxsize);
    }

    public MaskContainer() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pencil Container\n");
        sb.append(super.toString());
        return sb.toString();
    }

    public ArrayList<Mask> sortByAttachment(){
        items.sort(Comparator.comparing(Mask::getAttachmentType));
        return items;
    }
}
