package junseok.snr.study.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    private static final int CAPACITY = 10;
    private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(CAPACITY);

    public static void main(String[] args) {
        for (int i = 0; i < CAPACITY * 2; i++) {
            System.out.println(queue.add(String.valueOf(i)));
        }
    }
}
