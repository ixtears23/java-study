package junseok.snr.study.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class FutureFactory {

    public CompletableFuture<String> createFutureCompletedFuture() {
        return CompletableFuture.completedFuture("Test");
    }

    public CompletableFuture<String> supplyAsync() {
        Supplier<String> message = () -> {
            return "Hi, Junseok";
        };

        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(message);

        return completableFuture;
    }
}
