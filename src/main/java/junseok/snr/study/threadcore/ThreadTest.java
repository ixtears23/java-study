package junseok.snr.study.threadcore;

import lombok.SneakyThrows;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    @SneakyThrows
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        int maxThreads = coreCount * 2;
        int minThreads = coreCount;

        System.out.println(">>>>> maxThreads : " + maxThreads);
        System.out.println(">>>>> minThreads : " + minThreads);

        for (int currentThreadsCount = minThreads; currentThreadsCount <= maxThreads; currentThreadsCount++) {
            ExecutorService executor = Executors.newFixedThreadPool(currentThreadsCount);
            long startTime = System.currentTimeMillis();

            // 부하 생성
            for (int j = 0; j < 100; j++) {
                executor.submit(new Task());
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
            }

            long endTime = System.currentTimeMillis();
            System.out.println(">>>>> Thread count: " + currentThreadsCount + ", Execution time: " + (endTime - startTime) + "ms");
        }
    }

    private static class Task implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            Random random = SecureRandom.getInstanceStrong();
            int randomNumber = random.nextInt(10) + 1;
            Thread.sleep(5000);

        }
    }
}
