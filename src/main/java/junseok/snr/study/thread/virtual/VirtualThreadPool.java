package junseok.snr.study.thread.virtual;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadPool {
    public static void main(String[] args) throws InterruptedException {

        final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        final boolean running = true;
        while (running) {
            Thread.sleep(Duration.ofNanos(1));
            executorService.submit(() -> {
                final Thread thread = Thread.currentThread();
                System.out.println(thread);
                System.out.println(thread.getThreadGroup());
                System.out.println(thread.getState());
            });
        }
    }
}
