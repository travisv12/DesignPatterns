package Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence fibSequence = new FibonacciSequence();
        Iterator<Integer> iterator = fibSequence.iterator();

        System.out.println("First 10 Fibonacci numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}

