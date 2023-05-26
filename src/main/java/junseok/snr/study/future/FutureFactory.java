package junseok.snr.study.future;

import java.util.concurrent.CompletableFuture;

public class FutureFactory {

    public CompletableFuture<String> createFutureCompletedFuture(final String message) {
        return CompletableFuture.completedFuture(message);
    }

    public CompletableFuture<String> supplyAsync(final String message) {
        return CompletableFuture.supplyAsync(() -> message);
    }
}
