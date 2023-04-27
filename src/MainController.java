import Model.*;

import java.util.*;

public class MainController{
    int pencilSize = 10, notebookSize = 10, maskSize = 10, gloveSize = 10;
    Storage<Pencil> pencilStorage = new Storage<>(pencilSize);
    Storage<Notebook> notebookStorage = new Storage<>(notebookSize);
    Storage<Mask> maskStorage = new Storage<>(maskSize);
    Storage<Gloves> glovesStorage = new Storage<>(gloveSize);
    private Scanner scanner = new Scanner(System.in);

    public void run() throws Exception {
        System.out.println(pencilStorage.getSize());
        do{
            System.out.println("1. Register stocks");
            System.out.println("2. List the full stock");
            System.out.println("3. Change container size (Default was set to 50)");
            System.out.println("0. Exit");
            System.out.println();
        }while (processChoice());
    }

    private boolean processChoice() throws Exception {
        int choice = getInt(0, 4);
        switch (choice) {
            case 1 -> registerBoxes();
            case 2 -> {
                pencilStorage.sortItems();
                notebookStorage.sortItems();
                maskStorage.sortItems();
                glovesStorage.sortItems();

                System.out.println("Pencil storage:");
                pencilStorage.display();

                System.out.println("Notebook storage:");
                notebookStorage.display();

                System.out.println("Mask storage:");
                maskStorage.display();

                System.out.println("Gloves storage:");
                glovesStorage.display();
            }
            case 3 -> {
                System.out.println("Default was set to 50 for all containers");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Choose a container which you would like to set the size of it");
                System.out.println("1. Pencil");
                System.out.println("2. Notebook");
                System.out.println("3. Mask");
                System.out.println("4. Gloves");
                int ch = getInt(0, 4);
                int size = setSize();

                switch (ch){
                    case 1 -> pencilStorage.setMaxsize(size);//pencilSize = size;
                    case 2 -> notebookStorage.setMaxsize(size);//notebookSize = size;
                    case 3 -> maskStorage.setMaxsize(size);//maskSize = size;
                    case 4 -> glovesStorage.setMaxsize(size);//gloveSize = size;
                }
                System.out.println(pencilStorage.getSize());
            }
        }
        if (choice != 0){
            System.out.println();
            System.out.println("Press ENTER to continue...");
            scanner.nextLine();
        }
        return choice != 0;
    }

    private int setSize(){

        System.out.println("Enter the new size: ");
        int size = Integer.parseInt(scanner.nextLine());
        return size;
    }


    private int getInt(int min, int max) {
        int i = 0;
        boolean isCorrect;
        do {
            System.out.printf("Enter a number (%d-%d)%n", min, max);
            isCorrect = true;
            try {
                i = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                isCorrect = false;
            }
        } while (!isCorrect || i < min || i > max);

        return i;
    }

    private void registerBoxes() {
        String color, attachment = null, size;
        int itemCount = 0, pages, safetylevel;
        double price;
        System.out.println("What types of item you wanna register?");
        System.out.println("1. Pencil");
        System.out.println("2. Notebook");
        System.out.println("3. Mask");
        System.out.println("4. Gloves");
        int choice = getInt(0, 4);

        switch (choice) {
            case 1 -> {
                if(!pencilStorage.isFull()){
                    System.out.print("quantity: ");
                    itemCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("color: ");
                    color = scanner.nextLine();
                    System.out.print("price: ");
                    price = Integer.parseInt(scanner.nextLine());
                    pencilStorage.addItem(new Pencil(price, itemCount, color));
                    displayPacked();
                }
            }
            case 2 -> {
                if(!notebookStorage.isFull()){
                    System.out.print("quantity: ");
                    itemCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("pages: ");
                    pages = Integer.parseInt(scanner.nextLine());
                    System.out.print("price: ");
                    price = Integer.parseInt(scanner.nextLine());
                    notebookStorage.addItem(new Notebook(price, itemCount, pages));
                    displayPacked();
                }
            }
            case 3 -> {
                if(!maskStorage.isFull()){
                    System.out.print("quantity: ");
                    itemCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("Attachment Type: ");
                    attachment = scanner.nextLine();
                    System.out.print("safety level: ");
                    safetylevel = Integer.parseInt(scanner.nextLine());
                    maskStorage.addItem(new Mask(safetylevel, itemCount, attachment));
                    displayPacked();
                }
            }
            case 4 -> {
                if(!glovesStorage.isFull()){
                    System.out.print("quantity: ");
                    itemCount = Integer.parseInt(scanner.nextLine());
                    System.out.print("size: ");
                    size = scanner.nextLine();
                    System.out.print("Safety level: ");
                    safetylevel = Integer.parseInt(scanner.nextLine());
                    glovesStorage.addItem(new Gloves(safetylevel, itemCount, size));
                    displayPacked();
                }
            }
            default -> System.out.println("The typed item cannot be packed into boxes!!!!");
        }

    }

    public void displayPacked(){
        System.out.println("--------------------------");
        System.out.println("Items packed into the Storage!!!");
    }

    public MainController(){
        pencilStorage.addItem(new Pencil(0.5, 10, "blue"));
        pencilStorage.addItem(new Pencil(0.5, 10, "red"));
        notebookStorage.addItem(new Notebook(1.5, 20, 100));
        maskStorage.addItem(new Mask(2, 5, "earloop"));
        glovesStorage.addItem(new Gloves(3, 5, "medium"));
    }

}
