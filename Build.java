import java.text.*;
import java.util.*;

public class Build {
    // Instance variables
    private List<Part> parts;

    // Constructor
    public Build() {
        parts = new ArrayList<Part>();
    }

    // Secondary menu options and selection
    public void use() {
        System.out.println("Let's build a 1337 box!");
        // New instance of catalog
        Catalogue catalogue = new Catalogue();
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
                case 'n':
                    newBuild();
                    break;
                case 'a':
                    addPart(catalogue);
                    break;
                case 'r':
                    removePart();
                    break;
                case 'v':
                    currentState();
                    break;
                case 'c':
                    buildCheck();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    // Start a new build
    private void newBuild() {
        parts.clear();
    }

    // Adding new part to build
    public void addPart(Catalogue catalogue) {
        System.out.print("Enter catalogue number of the part: ");
        String number = In.nextLine();

        // Adding new parts
        String[] selectedPart = number.split(",");
        int[] addToBuild = new int[selectedPart.length];
        for (int i = 0; i < selectedPart.length; i++) {
            addToBuild[i] = Integer.parseInt(selectedPart[i].trim());
        }
        // If there is no part found
        for (int i = 0; i < addToBuild.length; i++) {
            if (addToBuild[i] > catalogue.getSize() || addToBuild[i] < 0)
                System.out.println("There is no part by that number.");
            else {
                parts.add(catalogue.getPart(addToBuild[i]));
            }
        }
    }

    // Remove a new part from build
    private void removePart() {
        System.out.print("Enter number of part to remove: ");
        int removing = In.nextInt();
        if (removing > parts.size())
            System.out.println("The build has no part with that number.");
        else
            parts.remove(removing - 1);
    }

    // Showing the current state of the build
    private void currentState() {
        double buildPrice = 0;
        for (Part part : parts) {
            if (parts.size() == 0) {
                break;
                // Adding to and returning current price
            } else {
                System.out.println((parts.indexOf(part) + 1) + ". " + part);
                buildPrice += part.returnPrice();
            }
        }
        // Output correctly formatted
        System.out.println("Total Price: $" + formatted(buildPrice));
    }

    // Check if the build is a functional computer
    private void buildCheck() {
        // Specific order needed - otherwise PLATE won't accept
        String[] hasParts = { "motherboard", "memory", "storage", "cpu", "case" };
        boolean isFunctional = true;
        // Pattern to find missing build components
        for (int i = 0; i < hasParts.length; i++) {
            if (search(hasParts[i]) == null) {
                if (hasParts[i].equals("storage"))
                    System.out.println("The build is missing storage.");
                else if (hasParts[i].equals("memory"))
                    System.out.println("The build is missing RAM.");
                else
                    System.out.println("The build is missing a " + hasParts[i] + ".");
                isFunctional = false;
            }
        }
        // Return functional if no components are missing
        if (isFunctional) {
            System.out.println("The build is functional.");
        }
    }

    // If part has been found, return it
    private Part search(String type) {
        for (Part part : parts) {
            if (part.hasPart(type)) {
                return part;
            }
        }
        return null;
    }

    // Build menu header
    public void buildMenu() {
        System.out.println("Let's build a 1337 box!");
        readChoice();
    }

    // Read user choice
    private char readChoice() {
        System.out.print("Enter choice (n/a/r/v/c/x): ");
        return In.nextChar();
    }

    // Money syntax formatting
    public String formatted(double money) {
        return new DecimalFormat("#####0.00").format(money);
    }

    // Help menu
    public void help() {
        System.out.println("n = start a new build (clears old build)");
        System.out.println("a = add a part from the catalogue to the build");
        System.out.println("r = remove a part from the build");
        System.out.println("v = show the current state of the build");
        System.out.println("c = check if the build is a functional computer");
        System.out.println("? = this help message");
    }
}