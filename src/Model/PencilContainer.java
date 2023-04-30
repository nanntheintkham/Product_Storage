package Model;

import java.util.ArrayList;
import java.util.Comparator;

public class PencilContainer extends Storage<Pencil>{

    public PencilContainer(int Maxsize) {
        super(Maxsize);
    }

    public PencilContainer() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pencil Container\n");
        sb.append(super.toString());
        return sb.toString();
    }

    public ArrayList<Pencil> sortByColor(){
        items.sort(Comparator.comparing(Pencil::getColor));
        return items;
    }
}
