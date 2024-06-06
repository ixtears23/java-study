package junseok.snr.study.thread;

import java.util.List;
import java.util.stream.IntStream;

public class VirtualThreadCreate {

    public static void main(String[] args) {
        final int threadCount = 100000;
        final IntStream stream1 = IntStream.range(0, threadCount);

        final long startTImeMillis = System.currentTimeMillis();
        final List<Thread> platformThreadList = stream1.mapToObj(i ->
                        Thread.ofVirtual()
                                .unstarted(VirtualThreadCreate::extracted))
                .toList();

        platformThreadList.forEach(Thread::start);

        final long endTImeMillis = System.currentTimeMillis();


        final IntStream stream2 = IntStream.range(0, threadCount);

        final long startTImeMillis2 = System.currentTimeMillis();
        final List<Thread> virtualThreadList = stream2.mapToObj(i ->
                        Thread.ofPlatform()
                                .unstarted(VirtualThreadCreate::extracted))
                .toList();

        virtualThreadList.forEach(Thread::start);

        final long endTImeMillis2 = System.currentTimeMillis();

        System.out.println(endTImeMillis - startTImeMillis);
        System.out.println(endTImeMillis2 - startTImeMillis2);

    }

    public static void extracted() {
        int x = 0;
        x++;
        x = x * 32;
        x = x / 3;
    }
}
