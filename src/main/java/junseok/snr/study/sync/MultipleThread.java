package junseok.snr.study.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleThread {

    public static void main(String[] args) {

        final ExecutorService service = Executors.newFixedThreadPool(1_000);

        for (int i = 0; i < 10_000; i++) {
            int count = i;
            service.submit(() -> System.out.println(count));
        }

        service.isShutdown();
        service.close();
    }
}
