package junseok.snr.study.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureDemo02 {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            executorService.submit(() -> 1);
        } finally {
            executorService.shutdown();
        }

    }

}
