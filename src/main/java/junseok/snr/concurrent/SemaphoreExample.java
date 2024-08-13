package junseok.snr.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {


    public static class PrinterQueue {
        private final Semaphore semaphore;

        public PrinterQueue(int printers) {
            semaphore = new Semaphore(printers);
        }

        public void printJob(Object document) {

            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + ": Printing document");
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }
    }

    static class Job implements Runnable {
        private final PrinterQueue printerQueue;

        public Job(PrinterQueue printerQueue) {
            this.printerQueue = printerQueue;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": Job started");
            printerQueue.printJob(Thread.currentThread());
        }
    }


    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue(3);

        final int threadSize = 10;
        Thread[] threads = new Thread[threadSize];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Job(printerQueue), "Thread " + (i + 1));
            threads[i].start();
        }
    }
}
