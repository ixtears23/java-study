package junseok.snr.study.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadCreat {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int i = 0;
            int j = 3;
            j= i + j;
            System.out.println(Thread.currentThread().getName());
        };

        final Thread vtu1 = Thread.ofVirtual().unstarted(runnable);
        final Thread vtu2 = Thread.ofVirtual().name("VTU").unstarted(runnable);
        final Thread vtu3 = Thread.ofVirtual().name("VTU2", 3000L).unstarted(runnable);

        final List<Thread> threadList = List.of(vtu1, vtu2, vtu3);

        threadList.forEach(t -> {
            System.out.println("READY===");
            System.out.println(vtu1.getThreadGroup());
            System.out.println(vtu1.getPriority());
            System.out.println(vtu1.getName());
            System.out.println(vtu1.getState());
            System.out.println("START===");
            t.start();
            System.out.println(t.getState());
            System.out.println(t.isVirtual());
            System.out.println(t.isDaemon());
            System.out.println(t.isAlive());
            System.out.println("End===");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });



        final Thread vts1 = Thread.ofVirtual().start(runnable);
        final Thread vts2 = Thread.ofVirtual().name("VTS").start(runnable);
        final Thread vts3 = Thread.ofVirtual().name("VTS2", 3000L).start(runnable);


        final Thread thread = Thread.startVirtualThread(runnable);

        thread.join();

        try (final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 1000)
                    .forEach(i -> executorService.submit(runnable));
        }
    }
}
