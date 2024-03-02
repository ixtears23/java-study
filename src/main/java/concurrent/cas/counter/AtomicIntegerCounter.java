package concurrent.cas.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements Counter {
    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public void increment() {
        int oldValue;
        do {
            oldValue = count.get();
        } while (!count.compareAndSet(oldValue, oldValue + 1));
    }

    @Override
    public int getCount() {
        return count.get();
    }

}
