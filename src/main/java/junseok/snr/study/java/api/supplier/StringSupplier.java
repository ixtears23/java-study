package junseok.snr.study.java.api.supplier;

import java.util.function.Supplier;

public class StringSupplier {
    public Supplier<String> toStringSupplier(String str) {
        return () -> str;
    }

    public String toString(String str) {
        return toStringSupplier(str).get();
    }
}
