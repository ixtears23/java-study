package junseok.snr.study.future;


import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

class FutureFactoryTest {

    private FutureFactory futureFactory = new FutureFactory();


    @Test
    void createFutureCompletedFutureTest() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> future = futureFactory.createFutureCompletedFuture();

        final String actual = future.get();
        final String expectedValue = "Test";
        assertThat(actual).isEqualTo(expectedValue);
    }

}