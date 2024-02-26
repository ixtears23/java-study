package junseok.snr.study.thread;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HackingThread {
    private static final int PASSWORD_LENGTH = 9999;

    public static void main(String[] args) {
        final Locker locker = new Locker(new Random().nextInt(PASSWORD_LENGTH));
        final HackerA hackerA = new HackerA(locker);
        final HackerB hackerB = new HackerB(locker);
        final PoliceThread policeThread = new PoliceThread(Arrays.asList(hackerA, hackerB));

        hackerA.start();
        hackerB.start();
        policeThread.start();
    }

    private static class Locker {
        private final int password;

        public Locker(int password) {
            this.password = password;
        }

        public boolean release(int password) {
            return this.password == password;
        }
    }

    private static class HackerThread extends Thread {
        protected final Locker locker;

        public HackerThread(Locker locker) {
            this.locker = locker;
        }

    }

    private static class HackerA extends HackerThread {
        public HackerA(Locker locker) {
            super(locker);
        }

        @Override
        public void run() {
            for (int password = 0; password <= PASSWORD_LENGTH; password++) {
                try {
                    System.out.println(">>> " + this.getClass().getSimpleName() + "password : " + password);
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }

                if (locker.release(password)) {
                    System.out.println("=== " + this.getClass().getSimpleName() + " Lock Release!!");
                    System.exit(0);
                }
            }
        }
    }

    private static class HackerB extends HackerThread {
        public HackerB(Locker locker) {
            super(locker);
        }

        @Override
        public void run() {
            for (int password = PASSWORD_LENGTH; password >= 0; password--) {
                try {
                    System.out.println(">>> " + this.getClass().getSimpleName() + "password : " + password);
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }

                if (locker.release(password)) {
                    System.out.println("=== " + this.getClass().getSimpleName() + " Lock Release!!");
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        private final List<HackerThread> hackerThreadList;
        public PoliceThread(List<HackerThread> hackerThreadList) {
            this.hackerThreadList = hackerThreadList;
        }

        @Override
        public void run() {
            for (int j = 0; j <= 1; j++) {
                final HackerThread hackerThread = hackerThreadList.get(j);
                for (int i = 10; i >= 0; i--) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                    }
                }
                hackerThread.interrupt();
                System.out.println("=== 잡았다! " + hackerThread.getName());
            }

            System.out.println();
            System.exit(0);
        }
    }

}
