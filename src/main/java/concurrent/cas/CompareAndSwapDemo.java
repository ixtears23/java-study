package concurrent.cas;

import concurrent.cas.counter.AtomicIntegerCounter;

public class CompareAndSwapDemo {

    public static void main(String[] args) throws InterruptedException {
        final AtomicIntegerCounter demo = new AtomicIntegerCounter();

        long startTimeMillis = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100_00_000; i++) {
                demo.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100_00_000; i++) {
                demo.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        long endTimeMillis = System.currentTimeMillis();

        System.out.println("=== Final count is : " + demo.getCount() + ", Elapsed time : " + (endTimeMillis - startTimeMillis));
    }
}
