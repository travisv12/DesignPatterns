package Decorator;

public class Main {
    public static void main(String[] args) {
        // Basic printer
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        System.out.println("\n--- Applying Decorators ---\n");

        // XML Printer
        Printer printer1 = new XMLPrinter(new BasicPrinter());
        printer1.print("Hello World!");

        // Encrypted + XML Printer
        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");
    }
}