package Model;

import java.awt.*;
import java.util.*;

public class Storage<T> implements Iterable<T>{
    protected ArrayList<T> items = new ArrayList<>();
    int Maxsize = 20;

    public void setMaxsize(int maxsize) {
        Maxsize = maxsize;
    }

    public Storage(int Maxsize) {
        this.Maxsize = Maxsize;
    }

    public Storage() {
    }


    public void addItem(T item) {
        if(item == null){
            throw new IllegalArgumentException("Item cannot be null");
        }
        else if (isFull()){
            System.out.println("Storage is full!");
        }
        else{
            items.add(item);
        }

    }

    public boolean isFull(){
        if(Maxsize <= items.size()){
            System.out.println("Storage is full");
            return true;
        }
        return false;
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

