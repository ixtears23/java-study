package junseok.snr.study.thread.virtual;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadPoolWithThreadLocal {
//     10MB 할당
    public static final ThreadLocal<byte[]> threadLocal = ThreadLocal.withInitial(() -> new byte[10 * 1024 * 1024]);

    @SneakyThrows
    public static void main(String[] args) {

        final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 100000; i++) {
            Thread.sleep(3);
            executorService.submit(() -> {
                System.out.println(Thread.currentThread());
                final byte[] bytes = threadLocal.get();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
    }
}
