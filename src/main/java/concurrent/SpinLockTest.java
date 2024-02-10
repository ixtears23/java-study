package concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpinLockTest {
    private static final SpinLock spinLock = new SpinLock();
    public static void main(String[] args) {
        final Runnable task = () -> {
            log.info(Thread.currentThread().getName() + " LOCK 획득 시도");
            spinLock.lock();
            try {
                log.info(Thread.currentThread().getName() + " LOCK 획득");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                spinLock.unlock();
                log.info(Thread.currentThread().getName() + " LOCK 해제");
            }
        };

        final int loopCount = 100;

        for (int i = 0; i < loopCount; i++) {
            new Thread(task).start();
        }
    }
}
