package Strategy;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SorterContext context = new SorterContext();
        Scanner scanner = new Scanner(System.in);
        int[] smallArray = generateRandomArray(30, 0, 100);
        int[] largeArray = generateRandomArray(100000, 1, 100000);

        while (true) {
            System.out.println("Choose sorting strategy:");
            System.out.println("1. Selection Sort");
            System.out.println("2. Bubble Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting program.");
                break;
            }

            SortStrategy strategy;
            switch (choice) {
                case 1:
                    strategy = new SelectionSortStrategy();
                    break;
                case 2:
                    strategy = new BubbleSortStrategy();
                    break;
                case 3:
                    strategy = new InsertionSortStrategy();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            testPerformance(context, strategy, smallArray, largeArray);
        }

        scanner.close();
    }

    private static void testPerformance(SorterContext context, SortStrategy strategy, int[] smallData, int[] largeData) {
        context.setStrategy(strategy);

        int[] small = smallData.clone();
        int[] large = largeData.clone();

        System.out.println("\n--- " + strategy.getClass().getSimpleName() + " ---");

        long start = System.nanoTime();
        context.sort(small);
        long end = System.nanoTime();
        System.out.println("Small Array Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        context.sort(large);
        end = System.nanoTime();
        System.out.println("Large Array Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    private static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max - min + 1) + min;
        }
        return arr;
    }
}