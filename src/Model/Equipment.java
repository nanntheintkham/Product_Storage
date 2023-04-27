package Model;

public abstract class Equipment implements Comparable<Equipment> {
    private final int safetyLevel;
    private int numberOfItems;

    public Equipment(int safetyLevel, int numberOfItems) {
        this.safetyLevel = safetyLevel;
        this.numberOfItems = numberOfItems;
    }

    public int getSafetyLevel() {
        return safetyLevel;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    @Override
    public int compareTo(Equipment o) {
        return safetyLevel - o.safetyLevel;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{security level: " + safetyLevel + ", number of items: " + numberOfItems;
    }


}

