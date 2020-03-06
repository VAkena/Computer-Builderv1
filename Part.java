import java.text.DecimalFormat;

public class Part {
    // Instance variables
    private String name;
    private String type;
    private double price;

    // Constructor with parameters
    public Part(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Adding a new part to the catalog menu - prompts
    public void partsMenu() {
        System.out.println("Welcome to the parts catalogue.");
        System.out.println("Enter choice (a/r/s/f/x): ");
        System.out.println("Enter part name: ");
        System.out.println("Enter part type: ");
        System.out.println("Enter part price: ");
    }

    // Return minimum price
    public boolean minimum(int min) {
        return price >= Double.valueOf(min);
    }

    // Return maximum price
    public boolean maximum(int max) {
        return price <= Double.valueOf(max);
    }

    // Is user chosen part found
    public boolean hasPart(String choice) {
        return choice.equals(type);
    }

    // Currency formatting
    public String formatted(double money) {
        return new DecimalFormat("#####0.00").format(money);
    }

    // Return price
    public double returnPrice() {
        return price;
    }

    // Showing parts in catalog in formatted view
    @Override
    public String toString() {
        return type.toUpperCase() + ": " + name + " @ $" + formatted(price);
    }
}
