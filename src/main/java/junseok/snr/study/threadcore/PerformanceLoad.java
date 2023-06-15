package junseok.snr.study.threadcore;

import lombok.Builder;
import lombok.Getter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PerformanceLoad {

    public static void main(String[] args) throws Exception {


    }

    public static class RunningThreadPoolExecutor extends ThreadPoolExecutor {

        public RunningThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        }
    }


    @Getter
    @Builder
    public static class Ticket {
        private Long id;
        private String name;
    }

    @Builder
    @Getter
    public static class Reservation {
        private Long id;
        private Ticket ticket;
    }
}
