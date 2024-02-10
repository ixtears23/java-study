package concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpinLockTest {
    private static final SpinLock spinLock = new SpinLock();
    public static void main(String[] args) {
        Runnable task = () -> {
            log.info(Thread.currentThread().getName() + " LOCK 획득 시도");
            spinLock.lock();
            try {
                log.info(Thread.currentThread().getName() + " LOCK 획득");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                spinLock.unlock();
                log.info(Thread.currentThread().getName() + "LOCK 해제");
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
