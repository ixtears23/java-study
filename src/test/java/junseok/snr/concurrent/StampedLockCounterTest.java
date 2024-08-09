package junseok.snr.concurrent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class StampedLockCounterTest {
    private Counter counter;

    @BeforeEach
    void setUp() {
        counter = new StampedLockCounter(0, 10_000);
    }

    @DisplayName("멀티 쓰레드에서 카운터 10,000 증가 시 10,000 이 정확히 카운트 되는 테스트")
    @Test
    void multiThreadTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        CountDownLatch latch = new CountDownLatch(10_000);

        Runnable r = () -> {
            try {
                counter.increment();
            } finally {
                latch.countDown();
            }
        };

        for (int i = 0; i < 10_000; i++) {
            executorService.submit(r);
        }

        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();

        Assertions.assertEquals(10_000, counter.getCount());
    }

    @DisplayName("단일 쓰레드에서 카운트 10,000 증가 시 카운터의 최종 값은 10,000")
    @Test
    void singleThreadTest() {
        for (int i = 0; i < 10_000; i++) {
            counter.increment();
        }

        Assertions.assertEquals(10_000, counter.getCount());
    }
}