package concurrent.cas.counter;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLockCounter implements Counter {
    private int count = 0;

    private static final SpinLock spinLock = new SpinLock();
    @Override
    public void increment() {
        spinLock.lock();
        count++;
        spinLock.unlock();
    }

    @Override
    public int getCount() {
        return this.count;
    }


    private static class SpinLock {
        private static final AtomicBoolean lock = new AtomicBoolean(false);
        public void lock() {
            while (!lock.compareAndSet(false, true)) {
            }
        }

        public void unlock() {
            lock.set(false);
        }
    }
}
