package Iterator;

import java.util.Iterator;

/**
 * Implements Iterator<Integer> to compute Fibonacci numbers on demand.
 * State (previous and current values) is kept here for independent iteration.
 */
public class FibonacciIterator implements Iterator<Integer> {

    private int prev = 0;
    private int curr = 1;

    @Override
    public boolean hasNext() {
        return true; // potentially infinite sequence
    }

    @Override
    public Integer next() {
        int nextVal = prev + curr;
        int result = curr;
        prev = curr;
        curr = nextVal;
        return result;
    }
}

