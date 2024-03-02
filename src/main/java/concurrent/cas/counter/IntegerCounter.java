package concurrent.cas.counter;

public class IntegerCounter implements Counter {
    private int count = 0;

    @Override
    public void increment() {
        count++;
    }

    @Override
    public int getCount() {
        return this.count;
    }
}
