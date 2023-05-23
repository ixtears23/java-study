package junseok.snr.study.java.eight;

import java.util.function.Supplier;

public class StringSupplier {
    public Supplier<String> toStringSupplier(String str) {
        return () -> str;
    }

    public String toString(String str) {
        return toStringSupplier(str).get();
    }
}
