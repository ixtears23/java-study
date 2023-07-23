package junseok.snr.thread;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Slf4j
public class ThreadPoolSize {
    private final int taskCount;
    private final Random random = new Random();
    private final int maxCores;

    public ThreadPoolSize(int taskCount) {
        this.taskCount = taskCount;
        this.maxCores = Runtime.getRuntime().availableProcessors() * 3;
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadPoolSize threadPoolSize = new ThreadPoolSize(1_000);
        threadPoolSize.executeTask();
    }

    private void executeTask() throws InterruptedException {
        log.info(">>>>> Test Start!!!");
        for (int poolSize = 1; poolSize <= this.maxCores; poolSize++ ) {
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
            writeToFile(String.format(">>>>> Test End %s !!", resultAwait));
        }

        long endTime = System.currentTimeMillis();
        log.info(">>>>> PoolSize : {}, Time : {}ms", poolSize, endTime - startTime);
        writeToFile(String.format(">>>>> PoolSize : %d, Time : %dms", poolSize, endTime - startTime));
    }

    private Runnable getRunnable() {
        return () -> {
            try {
                Thread.sleep(random.nextInt(3000) + 1000);
            } catch (InterruptedException e) {
                log.warn(">>>>> exception", e);
                Thread.currentThread().interrupt();
            }
        };
    }

    private void writeToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logfile.txt", true))) {
            writer.append(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
