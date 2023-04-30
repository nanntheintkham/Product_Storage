import Model.*;

import java.util.*;

public class MainController{
    PencilContainer pencilContainer = new PencilContainer();
    NotebookContainer notebookContainer = new NotebookContainer();
    MaskContainer maskContainer = new MaskContainer();
    GloveContainer glovesContainer = new GloveContainer();

    FileProcessor fileProcessor = new FileProcessor();
    private Scanner scanner = new Scanner(System.in);

    public void run() throws Exception {
        do{
            System.out.println("1. Register stocks");
            System.out.println("2. List contents of containers");
            System.out.println("3. List the customers in order by name");
            System.out.println("4. Change container size (Default was set to 20)");
            System.out.println("0. Exit");
            System.out.println();
        }while (processChoice());
    }

    private boolean processChoice() throws Exception {
        int choice = getInt(0, 4);
        switch (choice) {
            case 1 -> loadContainers();
            case 2 -> {

                fileProcessor.printContainers();

            }
            case 3 -> {
                fileProcessor.printOrdersByCustomerName();
            }
            case 4 -> {
                System.out.println("Default was set to 10 for all containers");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Choose a container which you would like to set the size of it");
                System.out.println("1. Pencil");
                System.out.println("2. Notebook");
                System.out.println("3. Mask");
                System.out.println("4. Gloves");
                int ch = getInt(0, 4);
                int size = setSize();

                switch (ch){
                    case 1 -> pencilContainer.setMaxsize(size);//pencilSize = size;
                    case 2 -> notebookContainer.setMaxsize(size);//notebookSize = size;
                    case 3 -> maskContainer.setMaxsize(size);//maskSize = size;
                    case 4 -> glovesContainer.setMaxsize(size);//gloveSize = size;
                }
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

    private void loadContainers() {
        System.out.println("Enter the name of the file (must include file type): ");
        String fileName = scanner.nextLine();
        fileProcessor.load(fileName);
    }

}
