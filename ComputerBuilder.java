public class ComputerBuilder {

    public static void main(String[] args) {
        // New computer builder starting at header method
        new ComputerBuilder().header();
    }

    // Initial fields
    private Catalogue catalogue;
    private Build currentBuild;

    // Constructor
    public ComputerBuilder() {
        catalogue = new Catalogue();
        currentBuild = new Build();
    }

    // Default titles
    private void header() {
        System.out.println("Welcome to Jaime's Computer Store");
        System.out.println("Quality Parts at the Best Prices");
        System.out.println("=================================");
        use();
    }

    // Main menu options and selection
    public void use() {
        System.out.println("1. Catalogue Menu");
        System.out.println("2. Build Menu");
        System.out.println("3. Exit");

        char choice;
        while ((choice = readChoice()) != '3') {
            switch (choice) {
                case '1':
                    catalogueMenu();
                    break;
                case '2':
                    buildMenu();
                    break;
                case '3':
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    // Option 1 - Catalog menu
    private void catalogueMenu() {
        catalogue.use();
        use();
        // Exiting the application
        System.exit(0);
    }

    // Option 2 - Build menu
    private void buildMenu() {
        currentBuild.use();
        use();
        System.exit(0);
    }

    // Reads user input
    private char readChoice() {
        System.out.print("Select option: ");
        return In.nextChar();
    }

    // Help menu
    private void help() {
        System.out.println("1 = interact with the catalogue");
        System.out.println("2 = build your computer!");
        System.out.println("? = this help message");
        System.out.println("1. Catalogue Menu");
        System.out.println("2. Build Menu");
        System.out.println("3. Exit");
    }
}
