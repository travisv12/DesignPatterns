package Iterator;

import java.util.Iterator;

/**
 * Implements the Sequence interface and returns a new FibonacciIterator.
 * This class does not maintain the Fibonacci state.
 * Rationale: Keeping the state in the iterator ensures that each iterator is independent.
 */
public class FibonacciSequence implements Sequence {

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }
}
