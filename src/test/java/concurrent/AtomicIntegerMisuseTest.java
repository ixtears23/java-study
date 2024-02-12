package concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class AtomicIntegerMisuseTest {

    @Test
    void automicInteger를_잘못_사용했을때_동시성이슈_발생_테스트() throws InterruptedException {

        final AtomicIntegerMisuse atomicIntegerMisuse = new AtomicIntegerMisuse();
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10_000; i++) {
            executor.submit(() -> atomicIntegerMisuse.addToSharedListIfCounterLessThan(100));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        final boolean hasInvalidValues = atomicIntegerMisuse.getSharedList()
                .stream()
                .anyMatch(value -> value > 100);

        log.info("=== 현재 Counter가 가지고 있는 값 : {}", atomicIntegerMisuse.getCounter().get());

        assertTrue(hasInvalidValues, "공유 리스트에 100보다 큰 값이 있습니다. 최고 큰 값은 [" + atomicIntegerMisuse.getCounter().get() + "]입니다.");

    }
}