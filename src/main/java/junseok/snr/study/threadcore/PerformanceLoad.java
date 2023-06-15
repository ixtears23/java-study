package junseok.snr.study.threadcore;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class PerformanceLoad {
    private static final int TOTAL_TICKETS = 1_200;
    private static final int TOTAL_TRAFFIC = 1_000_000;

    public static void main(String[] args) throws Exception {

        final LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        final ThreadFactory threadFactory = Executors.defaultThreadFactory();

        final RunningThreadPoolExecutor executor = new RunningThreadPoolExecutor(
                100, 200, 1, TimeUnit.SECONDS, workQueue, threadFactory
        );

        final Ticket concertTicket = Ticket.builder()
                .id(1L)
                .name("Concert")
                .build();

        for (int i = 0; i < TOTAL_TRAFFIC; i++) {
            final ReservationTask reservationTask = new ReservationTask(concertTicket);
            executor.execute(reservationTask);
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Total tickets sold : " + (TOTAL_TICKETS + concertTicket.getQuantity()));
    }

    public static class RunningThreadPoolExecutor extends ThreadPoolExecutor {

        public RunningThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        }
    }

    @RequiredArgsConstructor
    public static class ReservationTask implements Runnable {
        private final Ticket ticket;

        @Override
        public void run() {
            if (ticket.reserve()) {
                log.info("Ticket reserved by " + Thread.currentThread().getName());
            } else {
                log.info("Ticket sold out for " + Thread.currentThread().getName());
            }
        }
    }


    @Getter
    @Builder
    public static class Ticket {
        private Long id;
        private String name;
        private int quantity = TOTAL_TICKETS;

        public synchronized boolean reserve() {
            if (quantity > 0) {
                quantity--;
                return true;
            }
            return false;
        }
    }

    @Builder
    @Getter
    public static class Reservation {
        private Long id;
        private Ticket ticket;

    }
}
