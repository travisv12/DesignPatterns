package Strategy;

public class SorterContext {
    private SortStrategy sortStrategy;

    public SorterContext(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void setStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort(int[] arr) {
        sortStrategy.sort(arr);
    }
}