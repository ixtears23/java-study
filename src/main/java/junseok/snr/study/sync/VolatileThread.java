package junseok.snr.study.sync;

public class VolatileThread extends Thread {
    private final VolatileData volatileData;

    public VolatileThread(VolatileData volatileData) {
        this.volatileData = volatileData;
    }

    @Override
    public void run() {
//        int oldValue = volatileData.getCount();
//        System.out.println(Thread.currentThread().getId() + " Old Value : " + oldValue);
        volatileData.increaseCount();
//        int newValue = volatileData.getCount();
//        System.out.println(Thread.currentThread().getId() + " New Value : " + newValue);
    }
}
