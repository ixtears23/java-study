package junseok.snr.study.future;

import java.util.concurrent.CompletableFuture;

public class FutureFactory {

    public CompletableFuture<String> createFutureCompletedFuture() {
        return CompletableFuture.completedFuture("Test");
    }
}
