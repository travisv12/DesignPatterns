package Builder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Custom Computer Builder ===");
        System.out.println("Choose computer type:");
        System.out.println("1. Gaming Computer (pre-built)");
        System.out.println("2. Office Computer (pre-built)");
        System.out.println("3. Custom Build");
        System.out.print("Enter choice (1-3): ");
        int choice = Integer.parseInt(scanner.nextLine());

        ComputerBuilder builder;

        switch (choice) {
            case 1:
                builder = new GamingComputerBuilder();
                break;
            case 2:
                builder = new OfficeComputerBuilder();
                break;
            case 3:
                builder = new CustomComputerBuilder(scanner);
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Office Computer.");
                builder = new OfficeComputerBuilder();
        }

        ComputerDirector director = new ComputerDirector(builder);
        director.constructComputer();
        Computer computer = builder.getComputer();

        // Optional customizations
        System.out.println("\nWould you like to add accessories? (yes/no)");
        String accessoryChoice = scanner.nextLine().trim().toLowerCase();

        while (accessoryChoice.equals("yes")) {
            System.out.print("Enter accessory name: ");
            String accessory = scanner.nextLine();
            computer.addAccessory(accessory);

            System.out.print("Add another accessory? (yes/no): ");
            accessoryChoice = scanner.nextLine().trim().toLowerCase();
        }

        // Show final configuration
        System.out.println("\n=== Final Configuration ===");
        System.out.println(computer);
    }
}
