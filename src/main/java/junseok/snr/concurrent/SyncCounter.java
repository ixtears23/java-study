package junseok.snr.concurrent;

import lombok.Getter;

@Getter
public class SyncCounter {
    private int count = 0;
    private final int minCount;
    private final int maxCount;

    public SyncCounter(int minCount, int maxCount) {
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    public synchronized void increment() {
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
