package Model;

import java.lang.reflect.Field;
import java.util.*;

public class Storage<T> implements Iterable<T>{
    private ArrayList<T> items = new ArrayList<>();
    int Maxsize;


    public int getSize() {
        return Maxsize;
    }

    public void setMaxsize(int maxsize) {
        Maxsize = maxsize;
    }

    public Storage(int Maxsize) {
        this.Maxsize = Maxsize;
    }

    public void addItem(T item) {
        items.add(item);
    }

    public boolean isFull(){
        if(Maxsize <= items.size()){
            System.out.println("Storage is full");
            return true;
        }
        return false;
    }

    public void remove(T item) {
        items.remove(item);
    }

    public void clear() {
        items.clear();
    }

    public void display() {
        items.forEach(System.out::println);
    }

    public void sortItems() {
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return 0;
            }
        };
        Collections.sort(items, comparator);
    }

    public Iterator<T> iterator() {
        return items.iterator();
    }


}

