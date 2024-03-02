package concurrent.cas.counter;

public class SyncronizedIntegerCounter implements Counter {
    private int count = 0;

    @Override
    public synchronized void increment() {
        count++;
    }

    @Override
    public int getCount() {
        return this.count;
    }
}
