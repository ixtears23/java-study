package junseok.snr.study.future;


import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

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

    @Test
    void runAsyncTest() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        final String message = "Running";
        final CompletableFuture<Void> future = futureFactory.runAsync(message);

        countDownLatch.await(3, TimeUnit.SECONDS);

        assertThat(future.isDone()).isTrue();
    }

    @Test
    void thenAcceptTest() {
        final String threadName = "Test worker";
        final String asyncThreadName = "ForkJoinPool.commonPool-worker-";


        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            assertThat(getThreadName()).hasToString(asyncThreadName);
            return "Complete";
        });

        assertThat(completableFuture.isDone()).isFalse();
        assertThat(getThreadName()).hasToString(threadName);

        completableFuture.thenAccept(s -> {
            assertThat(getThreadName()).hasToString(threadName);
            assertThat(completableFuture.isDone()).isTrue();
        });

    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}