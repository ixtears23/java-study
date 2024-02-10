package concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SpinLockTest {

    private final Counter counter = new Counter();
    private final SpinLock spinLock = new SpinLock();

    @Test
    void 잠금_사용_카운트_증가시_기대값보다_작은_결과_발생_테스트() throws InterruptedException {
        final int numberOfThreads = 10_000;
        final int incrementPerThread = 100_000;
        final Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                spinLock.lock();
                try {
                    for (int j = 0; j < incrementPerThread; j++) {
                        counter.increment();
                    }
                } finally {
                    spinLock.unlock();
                }
            });
            threads[i].start();
        }

        // 모든 Thread 의 작업이 끝날때까지 대기
        for (Thread thread : threads) {
            thread.join();
        }

        final int expectedCount = numberOfThreads * incrementPerThread;
        log.info("=== expectedCount : {}", expectedCount);
        assertThat(counter.getCount()).isEqualTo(expectedCount);
    }


    @Test
    void 잠금없이_카운트_증가시_기대값보다_작은_결과_발생_테스트() throws InterruptedException {
        final int numberOfThreads = 10_000;
        final int incrementPerThread = 100_000;
        final Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementPerThread; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // 모든 Thread 의 작업이 끝날때까지 대기
        for (Thread thread : threads) {
            thread.join();
        }

        final int expectedCount = numberOfThreads * incrementPerThread;
        log.info("=== expectedCount : {}", expectedCount);
        assertThat(counter.getCount()).isLessThan(expectedCount);
    }
}