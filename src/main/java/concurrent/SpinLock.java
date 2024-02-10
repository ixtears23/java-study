package concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        while (!lock.compareAndSet(false, true)) {
            // 잠금이 해제될 때까지 대기
        }
    }

    public void unlock() {
        lock.set(false);
    }

}
