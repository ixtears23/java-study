package junseok.snr.study.thread.virtual;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class VirtualThreadPerformanceTest {

    public static void main(String[] args) {
        final ExecutorService virtualThreadPerTaskExecutor = Executors.newVirtualThreadPerTaskExecutor();

        final Thread thread = Thread.currentThread();
        log.info("=== thread : {}", thread);

        ThreadLocalContext.threadLocal.set("MAIN");

        IntStream.range(0, 10_000_000)
                        .forEach(s -> {
                            try {
                                final Thread streamThread = Thread.currentThread();
                                log.info("=== streamThread : {}", streamThread);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            log.info("=== THreadLocal");
                            virtualThreadPerTaskExecutor.submit(() -> {
                                final Thread virtualThread = Thread.currentThread();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                log.info("=== thread : {}", virtualThread);
                            })
                            ;

                        });




        final ExecutorService executorService1 = Executors.newFixedThreadPool(200);

//        executorService1.submit(() > {
//            Thread platformThread = Thread.currentThread();
//            log.info("=== thread : {}", platformThread);
//        });
    }

    public static class ThreadLocalContext {
        public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    }

    public static class InheritableThreadLocalContext {
        public static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
    }}
