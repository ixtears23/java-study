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
    public static final int CORE_POOL_SIZE = 32;
    public static final int MAXIMUM_POOL_SIZE = 32;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        final LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        final ThreadFactory threadFactory = Executors.defaultThreadFactory();


        final ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.SECONDS, workQueue, threadFactory
        );


        final Ticket concertTicket = Ticket.builder()
                .id(1L)
                .name("Concert")
                .quantity(TOTAL_TICKETS)
                .build();

        for (int i = 0; i < TOTAL_TRAFFIC; i++) {
            final ReservationTask reservationTask = new ReservationTask(concertTicket);
            executor.execute(reservationTask);
        }

        executor.shutdown();
        executor.close();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        log.info("총 티켓 : {}, 판매된 티켓 : {}, 남은 티켓 : {}",
                TOTAL_TICKETS,
                TOTAL_TICKETS- concertTicket.getQuantity(),
                concertTicket.getQuantity());
        long endTime = System.currentTimeMillis();
        log.info("실행 시간(Millis) : {}" , endTime - startTime);
        log.info("core_pool_size : {}, max_pool_size : {}, traffic : {}" , CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, TOTAL_TRAFFIC);
    }

    @RequiredArgsConstructor
    public static class ReservationTask implements Runnable {
        private final Ticket ticket;

        @Override
        public void run() {
            if (ticket.reserve()) {
                log.debug("Ticket reserved by " + Thread.currentThread().getName());
            } else {
                log.debug("Ticket sold out for " + Thread.currentThread().getName());
            }
        }
    }


    @Getter
    @Builder
    public static class Ticket {
        private Long id;
        private String name;
        private int quantity;

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
