package Model;

import java.util.ArrayList;
import java.util.Comparator;

public class GloveContainer extends Storage<Gloves>{

    public GloveContainer(int Maxsize) {
        super(Maxsize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pencil Container\n");
        sb.append(super.toString());
        return sb.toString();
    }

    public GloveContainer() {
    }

    public ArrayList<Gloves> sortBySize(){
        items.sort(Comparator.comparing(Gloves::getSize));
        return items;
    }
}
