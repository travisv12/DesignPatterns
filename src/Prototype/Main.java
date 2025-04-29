package Prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Recommendation> recommendations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Recommendation fantasyTeens = new Recommendation("Teen Fantasy Lovers");
        fantasyTeens.addBook(new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", "Fantasy", 1997));
        fantasyTeens.addBook(new Book("Rick Riordan", "Percy Jackson & the Olympians", "Fantasy", 2005));
        recommendations.add(fantasyTeens);

        while (true) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. View all recommendations");
            System.out.println("2. Clone a recommendation");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    showRecommendations();
                    break;
                case "2":
                    cloneAndModifyRecommendation();
                    break;
                case "3":
                    System.out.println("Exiting. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    private static void showRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
        } else {
            for (int i = 0; i < recommendations.size(); i++) {
                System.out.println("[" + i + "] " + recommendations.get(i));
            }
        }
    }

    private static void cloneAndModifyRecommendation() {
        showRecommendations();
        System.out.print("Enter the number of the recommendation to clone: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index < 0 || index >= recommendations.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Recommendation original = recommendations.get(index);
        Recommendation clone = original.clone();

        System.out.print("Enter new target audience: ");
        String newAudience = scanner.nextLine();
        clone.setTargetAudience(newAudience);

        System.out.println("Current books in cloned list:");
        for (Book book : clone.getBooks()) {
            System.out.println(" - " + book);
        }

        System.out.print("Would you like to add a new book? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            System.out.print("Publication Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            clone.addBook(new Book(author, title, genre, year));
        }

        recommendations.add(clone);
        System.out.println("Cloned and modified recommendation added!");
    }
}

