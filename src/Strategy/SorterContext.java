package Strategy;

public class SorterContext {
    private SortStrategy sortStrategy;

    public SorterContext() {
        this.sortStrategy = new BubbleSortStrategy();
    }

    public void setStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort(int[] arr) {
        sortStrategy.sort(arr);
    }
}