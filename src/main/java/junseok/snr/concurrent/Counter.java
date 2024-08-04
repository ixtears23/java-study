package junseok.snr.concurrent;

import lombok.Getter;

@Getter
public class Counter {
    private int count;
    private final int minCount;
    private final int maxCount;

    public Counter(int minCount, int maxCount) {
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    public void increment() {
        if (maxCount >= count) {
            count++;
        }
    }

    public void decrement() {
        if (minCount <= count) {
            count--;
        }
    }

    @Override
    public String toString() {
        return "Counter{" +
                "count=" + count +
                '}';
    }
}
