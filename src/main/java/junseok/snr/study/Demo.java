package junseok.snr.study;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        int i = 0;
        while ( i < 50 ) {
            final int revenue = new Random().nextInt(3000) + 1000;
            System.out.println(revenue);
            i++;
        }
    }
}
