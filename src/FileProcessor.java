import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.*;

public class FileProcessor {
    private final Map<String, PencilContainer> pencilContainers;
    private final Map<String, NotebookContainer> notebookContainers;
    private final Map<String, MaskContainer> maskContainers;
    private final Map<String, GloveContainer> glovesContainers;
    private final Map<String, Order> orders;

    public FileProcessor() {
        this.pencilContainers = new HashMap<>();
        this.notebookContainers = new HashMap<>();
        this.maskContainers = new HashMap<>();
        this.glovesContainers = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void load(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String itemType = parts[0];
                double price = Double.parseDouble(parts[1]);
                int numPieces = Integer.parseInt(parts[2]);
                String colorSizeAttachment = parts[3];
                String customerName = parts[4];
                String customerOffice = parts[5];
                String identifier = customerName + "-" + customerOffice;

                switch (itemType) {
                    case "pencil":
                        Pencil pencil = new Pencil(price, numPieces, colorSizeAttachment);
                        if (pencilContainers.containsKey(itemType)) {
                            pencilContainers.get(itemType).addItem(pencil);
                        } else {
                            PencilContainer container = new PencilContainer();
                            container.addItem(pencil);
                            pencilContainers.put(itemType, container);
                        }
                        break;
                    case "notebook":
                        Notebook notebook = new Notebook(price, numPieces, Integer.parseInt(colorSizeAttachment));
                        if (notebookContainers.containsKey(itemType)) {
                            notebookContainers.get(itemType).addItem(notebook);
                        } else {
                            NotebookContainer container = new NotebookContainer();
                            container.addItem(notebook);
                            notebookContainers.put(itemType, container);
                        }
                        break;
                    case "mask":
                        Mask mask = new Mask(price, numPieces, colorSizeAttachment);
                        if (maskContainers.containsKey(itemType)) {
                            maskContainers.get(itemType).addItem(mask);
                        } else {
                            MaskContainer container = new MaskContainer();
                            container.addItem(mask);
                            maskContainers.put(itemType, container);
                        }
                        break;
                    case "gloves":
                        Gloves gloves = new Gloves(price, numPieces, colorSizeAttachment);
                        if (glovesContainers.containsKey(itemType)) {
                            glovesContainers.get(itemType).addItem(gloves);
                        } else {
                            GloveContainer container = new GloveContainer();
                            container.addItem(gloves);
                            glovesContainers.put(itemType, container);
                        }
                        break;
                    default:
                        System.out.println("Unknown item type: " + itemType);
                        break;
                }

                Order order = new Order(itemType, price, numPieces, colorSizeAttachment, customerName, customerOffice);
                orders.put(identifier, order);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    public void printOrdersByCustomerName() {
        TreeMap<String, List<Order>> customerOrders = new TreeMap<>();

        for (Order order : orders.values()) {
            String customerName = order.getCustomerName();
            String office = order.getOffice();
            String key = customerName + office;

            if (!customerOrders.containsKey(key)) {
                customerOrders.put(key, new ArrayList<>());
            }

            List<Order> ordersList = customerOrders.get(key);
            ordersList.add(order);
        }

        for (Map.Entry<String, List<Order>> entry : customerOrders.entrySet()) {
            String key = entry.getKey();
            List<Order> ordersList = entry.getValue();
            Collections.sort(ordersList, new OrderComparator());

            System.out.println("Customer Name: " + ordersList.get(0).getCustomerName() + ", Office: " + ordersList.get(0).getOffice() + ", " + entry.getValue().toString());

        }
    }





    public void printContainers() {
        System.out.println("Pencil Container:");
        pencilContainers.entrySet().forEach(entry -> {
            String contents = String.valueOf(entry.getValue().sortByColor());
            Pattern pattern = Pattern.compile("\\{(.*?)\\}");
            Matcher matchPattern = pattern.matcher(contents);

            while (matchPattern.find()){
                System.out.println(matchPattern.group(1));
            }

        });

        System.out.println("Notebook Container: ");
        notebookContainers.entrySet().forEach(entry -> {
            String contents = String.valueOf(entry.getValue().sortByPages());
            Pattern pattern = Pattern.compile("\\{(.*?)\\}");
            Matcher matchPattern = pattern.matcher(contents);

            while (matchPattern.find()){
                System.out.println(matchPattern.group(1));
            }
        });

        System.out.println("Mask Container: ");
        maskContainers.entrySet().forEach(entry -> {
            String contents = String.valueOf(entry.getValue().sortByAttachment());
            Pattern pattern = Pattern.compile("\\{(.*?)\\}");
            Matcher matchPattern = pattern.matcher(contents);

            while (matchPattern.find()){
                System.out.println(matchPattern.group(1));
            }

        });

        System.out.println("Glove Container: ");
        glovesContainers.entrySet().forEach(entry -> {
            String contents = String.valueOf(entry.getValue().sortBySize());
            Pattern pattern = Pattern.compile("\\{(.*?)\\}");
            Matcher matchPattern = pattern.matcher(contents);

            while (matchPattern.find()){
                System.out.println(matchPattern.group(1));
            }
        });


    }


}