package junseok.snr.study.sync;

public class VolatileMain {

    private static final int noOfThreads = 10000;

    public static void main(String[] args) throws InterruptedException {
        final VolatileData volatileData = new VolatileData();
        final Thread[] threads = new Thread[noOfThreads];
        for (int i = 0; i < noOfThreads; i++) {
            threads[i] = new VolatileThread(volatileData);
        }
        for (int i = 0; i < noOfThreads; i++) {
            threads[i].start();
        }
//        for (int i = 0; i < noOfThreads; i++) {
//            threads[i].join();
//        }
        System.out.println(volatileData.getCount());
    }
}
