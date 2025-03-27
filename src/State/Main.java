package State;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        GameCharacter character = new GameCharacter(name);

        while (true) {
            character.displayStatus();
            System.out.println("\nChoose an action:");
            System.out.println("1. Train");
            System.out.println("2. Meditate");
            System.out.println("3. Fight");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    character.train();
                    break;
                case 2:
                    character.meditate();
                    break;
                case 3:
                    character.fight();
                    break;
                case 4:
                    System.out.println("Exiting game...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}