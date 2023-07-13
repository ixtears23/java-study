package junseok.snr.study.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

@Slf4j
public class MemoryLeak {
    public static void main(String[] args) throws InterruptedException {
        final Vector<Byte[]> vector = new Vector<>(200);

        while (true) {
            Thread.sleep(300);
            final Byte[] bytes = new Byte[1048576];
            vector.add(bytes);
            final Runtime runtime = Runtime.getRuntime();
            final long maxMemory = runtime.maxMemory();
            final long totalMemory = runtime.totalMemory();
            final long freeMemory = runtime.freeMemory();

            log.info(
                    ">>>>> maxMemory : {}, totalMemory : {}, freeMemory : {}",
                    maxMemory,
                    totalMemory,
                    freeMemory
            );
        }
    }
}
