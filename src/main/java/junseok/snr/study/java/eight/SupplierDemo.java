package junseok.snr.study.java.eight;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hi, Junseok";

        System.out.println(supplier.get());
    }
}
