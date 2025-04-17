package Builder;

import java.util.Scanner;

public class CustomComputerBuilder implements ComputerBuilder {

    private Computer computer;
    private Scanner scanner;

    public CustomComputerBuilder(Scanner scanner) {
        this.computer = new Computer();
        this.scanner = scanner;
    }

    private int getUserChoice(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        int choice = 0;
        while (choice < 1 || choice > options.length) {
            System.out.print("Enter your choice (1-" + options.length + "): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
        return choice - 1;
    }

    public void buildProcessor() {
        System.out.println("\nChoose Processor:");
        String[] processors = { "Intel Core i5", "Intel Core i7", "AMD Ryzen 5", "AMD Ryzen 7" };
        int index = getUserChoice(processors);
        computer.setProcessor(processors[index]);
    }

    public void buildRAM() {
        System.out.println("\nChoose RAM:");
        String[] ramOptions = { "8", "16", "32", "64" };
        int index = getUserChoice(ramOptions);
        computer.setRam(Integer.parseInt(ramOptions[index]));
    }

    public void buildHardDrive() {
        System.out.println("\nChoose Hard Drive:");
        String[] drives = { "512 GB SSD", "1 TB SSD", "2 TB HDD", "1 TB SSD + 2 TB HDD" };
        int index = getUserChoice(drives);
        computer.setHardDrive(drives[index]);
    }

    public void buildGraphicsCard() {
        System.out.println("\nChoose Graphics Card:");
        String[] gpus = { "Integrated Graphics", "NVIDIA GTX 1660", "NVIDIA RTX 3060", "AMD Radeon RX 6700" };
        int index = getUserChoice(gpus);
        computer.setGraphicsCard(gpus[index]);
    }

    public void buildOperatingSystem() {
        System.out.println("\nChoose Operating System:");
        String[] osOptions = { "Windows 10", "Windows 11", "Ubuntu Linux", "No OS" };
        int index = getUserChoice(osOptions);
        computer.setOperatingSystem(osOptions[index]);
    }

    public Computer getComputer() {
        return this.computer;
    }
}

