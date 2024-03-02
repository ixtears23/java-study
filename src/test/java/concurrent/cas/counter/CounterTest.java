package concurrent.cas.counter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class CounterTest {
    private static final int COUNT = 1_000_000;
    private static final int THREAD_COUNT = 10;

    @RepeatedTest(10)
    void integerCounterTest() {
        testCounter(IntegerCounter::new);
    }

    @RepeatedTest(10)
    void atomicIntegerCounterTest() {
        testCounter(AtomicIntegerCounter::new);
    }

    @RepeatedTest(10)
    void synchronizedIntegerCounterTest() {
        testCounter(SyncronizedIntegerCounter::new);
    }

    @RepeatedTest(10)
    void spinLockIntegerCounterTest() {
        testCounter(SpinLockCounter::new);
    }

    void testCounter(Supplier<Counter> counterSupplier) {

        final Counter counter = counterSupplier.get();
        final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        final int expectedCount = COUNT * THREAD_COUNT;

        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        final long startTime= System.nanoTime();

        for (int thread = 0; thread < THREAD_COUNT; thread++) {
            executorService.execute(() -> {
                try {
                    for (int i = 0 ;i < COUNT; i++) {
                        counter.increment();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("=== await error", e);
        }

        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        log.info("=== Elapsed time :: {}", duration +  "ms");

        assertThat(counter.getCount()).isEqualTo(expectedCount);
    }
}