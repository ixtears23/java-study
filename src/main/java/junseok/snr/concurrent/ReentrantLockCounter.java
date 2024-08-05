package junseok.snr.concurrent;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@ToString
public class ReentrantLockCounter {
    private final ReentrantLock lock = new ReentrantLock();
    private int count;
    private final int minCount;
    private final int maxCount;

    public ReentrantLockCounter(int minCount, int maxCount) {
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    public void increment() {
        lock.lock();
        try {
            if (maxCount >= count) {
                count++;
            }
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            if (minCount <= count) {
                count--;
            }
        } finally {
            lock.unlock();
        }
    }
}
