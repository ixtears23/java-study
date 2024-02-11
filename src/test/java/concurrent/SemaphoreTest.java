package concurrent;

import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SemaphoreTest {

    @RepeatedTest(20)
    void semaphore가_동시에_접근할수있는_스레드수_테스트() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(3);
        final AtomicInteger successCount = new AtomicInteger();
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1_000; i++) {
            executor.submit(() -> {
                try {
                    if (semaphore.tryAcquire(1, TimeUnit.NANOSECONDS)) {
                        successCount.incrementAndGet();
                        Thread.sleep(1000);
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(100, TimeUnit.SECONDS);


        assertEquals(3, successCount.get());
    }
}
