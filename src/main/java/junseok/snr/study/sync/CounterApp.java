package junseok.snr.study.sync;

public class CounterApp {


    public static final int threadCount = 10000;

    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();

        Runnable r = () -> {
            counter.incrementCount();
        };

        new Thread(r);

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(r);
        }

        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }

//        for (int i = 0; i < threadCount; i++) {
//            threads[i].join();
//        }

        // t1, t2, t3 Thread가 모두 종료된 후에 count 값을 가져오기 잠시 Sleep
//        Thread.sleep(5000);
        System.out.println();
        System.out.println(">>>>> count print Thread : " + Thread.currentThread());
        System.out.println(">>>>> counter.getCount() : " + counter.getCount());
    }
}
