package junseok.snr.study.future;


import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

class FutureFactoryTest {

    private final FutureFactory futureFactory = new FutureFactory();


    @Test
    void createFutureCompletedFutureTest() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> future = futureFactory.createFutureCompletedFuture();

        final String actual = future.get();
        final String expectedValue = "Test";
        assertThat(actual).isEqualTo(expectedValue);
    }

    @Test
    void supplyAsyncTest() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> completableFuture = futureFactory.supplyAsync();
        final CompletableFuture<String> completableFuture2 = completableFuture.thenApply(result -> "test" + result);

        assertThat(completableFuture.get()).isEqualTo("Hi, Junseok");
        assertThat(completableFuture2.get()).isEqualTo("testHi, Junseok");
    }

}