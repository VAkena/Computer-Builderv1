import java.util.*;

public class Catalogue {
    // Instance variables
    private List<Part> parts;

    // Constructor with no parameters
    public Catalogue() {
        parts = new ArrayList<Part>();

        // Items added to array
        parts.add(new Part("evo 860", "storage", 155.00));
        parts.add(new Part("daskeyboard", "keyboard", 239.00));
        parts.add(new Part("i5", "cpu", 365.00));
        parts.add(new Part("Corsair 16G", "memory", 299.00));
        parts.add(new Part("ASUS ROG", "motherboard", 159.00));
        parts.add(new Part("sheetmetal box", "case", 39.00));
        parts.add(new Part("Ryzen 7", "cpu", 299.00));
    }

    // Secondary menu options for Parts Catalog
    public void use() {
        System.out.println("Welcome to the parts catalogue.");

        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
                case 'a':
                    addNewPart();
                    break;
                case 'r':
                    removePart();
                    break;
                case 's':
                    showCatalogue();
                    break;
                case 'f':
                    filter();
                    break;

                default:
                    help();
                    break;
            }
        }
    }

    // Secondary menu header
    public void catalogueMenu() {
        System.out.println("Welcome to the parts catalogue.");
        readChoice();
    }

    // Read user input
    private char readChoice() {
        System.out.print("Enter choice (a/r/s/f/x): ");
        return In.nextChar();
    }

    // Adding new parts to catalog
    private void addNewPart() {
        // Asking and reading part name
        System.out.print("Enter part name: ");
        String name = In.nextLine();

        // Asking and reading part type
        System.out.print("Enter part type: ");
        String part = In.nextLine();

        // Asking and reading part price
        System.out.print("Enter part price: ");
        double price = In.nextDouble();

        // Adding parts to arrayList
        parts.add(new Part(name, part, price));
    }

    // Removing a part from the arrayList of parts
    public void removePart() {
        System.out.print("Enter catalogue number of part to remove: ");
        // Array starts at 0 so -1 subtraction needed
        int num = In.nextInt() - 1;
        if (num < 0 || num >= parts.size()) {
            System.out.println("The catalogue has no part with that number. ");
        } else {
            parts.remove(num);
        }
    }

    // Showing available items in catalog
    public void showCatalogue() {
        int item = 1;
        for (Part part : parts) {
            // Formatting catalog items
            System.out.println(item + ". " + part);
            item++;
        }
    }

    // Type, Price and Type/Price filter combined - not ideal
    private void filter() {
        // User prompts
        System.out.print("Enter type of part to view ('all' for no filtering): ");
        String choice = In.nextLine();
        System.out.print("Enter minimum price ('-1' for no filtering): ");
        int min = In.nextInt();

        // No filtering
        if (min == -1) {
            if (choice.equals("all")) {
                showCatalogue();
            } else {
                int i = 1;
                for (Part parts : parts) {
                    if (parts.hasPart(choice)) {
                        System.out.println(i + ". " + parts);
                    }
                    i++;
                }
            }
            // Filtering by price
        } else {
            System.out.print("Enter maximum price: ");
            int max = In.nextInt();
            if (min > max) {
                System.out.println("Minimum price shouldn't be greater than maximum price. ");
                // If user enters "all", print out everything
            } else {
                if (!choice.equals("all")) {
                    int i = 1;
                    for (Part part : parts) {
                        if (part.hasPart(choice) && part.minimum(min) && part.maximum(max)) {
                            System.out.println(i + ". " + part);
                        }
                        i++;
                    }
                    // Filtering by both minimum and maximum price
                } else {
                    int i = 1;
                    for (Part part : parts) {
                        if (part.minimum(min) && part.maximum(max)) {
                            System.out.println(i + ". " + part);
                        }
                        i++;
                    }
                }
            }
        }
    }

    // Catalog help menu
    private void help() {
        System.out.println("a = add a new part to the catalogue");
        System.out.println("r = remove a part from the catalogue");
        System.out.println("s = show the catalogue");
        System.out.println("f = show a filtered view of the catalogue");
        System.out.println("? = this help message ");
    }

    // Returning array size
    public int getSize() {
        return parts.size();
    }

    // Returning part selected
    public Part getPart(int partSelected) {
        return parts.get(partSelected - 1);
    }
}