package junseok.snr.study.thread;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

@RequiredArgsConstructor
@Slf4j
public class ThreadPoolSize {
    private final int maxPoolSize;
    private final int taskCount;
    private final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        final ThreadPoolSize threadPoolSize = new ThreadPoolSize(1_000, 10);
        threadPoolSize.executeTask();
    }

    private void executeTask() throws InterruptedException {
        log.info(">>>>> Test Start!!!");
        for (int poolSize = 1; poolSize <= this.maxPoolSize; poolSize++ ) {
            executeTask(poolSize);
        }
    }

    private void executeTask(int poolSize) throws InterruptedException {
        long startTime;
        try (ExecutorService executorService = Executors.newFixedThreadPool(poolSize)) {
            startTime = System.currentTimeMillis();

            for (int i = 0; i < this.taskCount; i++) {
                executorService.submit(getRunnable());
            }

            executorService.shutdown();
            final boolean resultAwait = executorService.awaitTermination(30, TimeUnit.SECONDS);
            log.info(">>>>> Test End {} !!", resultAwait);
        }

        long endTime = System.currentTimeMillis();
        log.info(">>>>> PoolSize : {}, Time : {}ms", poolSize, endTime - startTime);
    }

    private Runnable getRunnable() {
        return () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.warn(">>>>> exception", e);
                Thread.currentThread().interrupt();
            }
        };
    }
}
