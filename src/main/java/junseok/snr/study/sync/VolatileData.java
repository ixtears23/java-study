package junseok.snr.study.sync;

public class VolatileData {
    private volatile int count = 0;

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        ++count;
    }

}