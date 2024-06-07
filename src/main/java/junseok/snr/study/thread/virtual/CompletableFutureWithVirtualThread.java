package junseok.snr.study.thread.virtual;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureWithVirtualThread {
    public static void main(String[] args) {

        final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "VirtualThread")
                .thenApplyAsync(String::toUpperCase)
                .thenAcceptAsync(upperCaseResult -> {
                    System.out.println("Upper Case: " + upperCaseResult + " in Thread : " + Thread.currentThread().getName());
                });

        future.join();


    }
}
