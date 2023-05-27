package junseok.snr.study.future;


import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FutureFactoryTest {

    private final FutureFactory futureFactory = new FutureFactory();


    @Test
    void createFutureCompletedFutureTest() throws ExecutionException, InterruptedException {
        final String message = "Test";
        final String expectedValue = "Test";

        final CompletableFuture<String> future = futureFactory.createFutureCompletedFuture(message);

        final String actual = future.get();
        assertThat(actual).isEqualTo(expectedValue);
    }

    @Test
    void supplyAsyncTest() throws ExecutionException, InterruptedException {
        final String message = "Test";
        final String appendMessage = "Hi, Tom!!";

        final CompletableFuture<String> completableFuture = futureFactory.supplyAsync(message);
        final CompletableFuture<String> completableFuture2 = completableFuture.thenApply(result -> result + appendMessage);

        assertThat(completableFuture.get()).isEqualTo(message);
        assertThat(completableFuture2.get()).isEqualTo(message + appendMessage);
    }

    @Test
    void failedFutureTest() {
        final String exceptionMessage = "CompletableFuture 실패!!!";
        final Throwable throwable = new RuntimeException(exceptionMessage);
        final CompletableFuture<String> completableFuture = futureFactory.failedFuture(throwable);

        completableFuture.exceptionally(ex -> {
            assertThat(ex).isEqualTo(throwable);
            return null;
        });


    }
}