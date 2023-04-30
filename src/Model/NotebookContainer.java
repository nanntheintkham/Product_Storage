package Model;

import java.util.ArrayList;
import java.util.Comparator;

public class NotebookContainer extends Storage<Notebook>{
    public NotebookContainer(int Maxsize) {
        super(Maxsize);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pencil Container\n");
        sb.append(super.toString());
        return sb.toString();
    }

    public NotebookContainer() {
    }

    public ArrayList<Notebook> sortByPages(){
        items.sort(Comparator.comparing(Notebook::getPages));
        return items;
    }
}
