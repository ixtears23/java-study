package junseok.snr.study.multithread.volatiles;

public class VolatileDemo {
    private static int count = 0;
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) count++;
        final long endTime = System.currentTimeMillis();
        System.out.println(">>>>> time : " + (endTime - startTime));

    }
}
