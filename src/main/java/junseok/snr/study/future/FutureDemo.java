package junseok.snr.study.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(System.out::println);
        completableFuture.complete("Good Job!");



        final String s = completableFuture.get();

        System.out.println(s);


    }
}
