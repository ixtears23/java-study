package junseok.snr.study.thread;

public class Termination {
    public static void main(String[] args) {
        final Thread thread = new Thread(new BlockingTask());
        thread.start();
        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("=== Existing blocking thread");
            }
        }
    }
}
