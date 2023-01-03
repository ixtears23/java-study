package junseok.snr.study.sync;

public class Counter {
    private volatile int count;

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
