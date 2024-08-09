package junseok.snr.concurrent;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

@Getter
@ToString
public class StampedLockCounter implements Counter {
    private final StampedLock lock = new StampedLock();
    private int count;
    private final int minCount;
    private final int maxCount;

    public StampedLockCounter(int minCount, int maxCount) {
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    public void increment() {
        long stamp = lock.writeLock();
        try {
            if (maxCount >= count) {
                count++;
            }
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public void decrement() {
        long stamp = lock.writeLock();
        try {
            if (minCount <= count) {
                count--;
            }
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}
