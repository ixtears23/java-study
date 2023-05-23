package junseok.snr.study.java.eight;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        System.out.println(toString("Hi, Junseok"));
    }

    public static Supplier<String> toStringSupplier(String str) {
        return () -> str;
    }

    public static String toString(String str) {
        return toStringSupplier(str).get();
    }


}
