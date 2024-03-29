package junseok.snr.study.java.api.supplier;

import java.util.function.Supplier;

public class RandomSupplier {

    public Supplier<Double> randomSupplier() {
        return Math::random;
    }

    public Double toRandom() {
        return randomSupplier().get();
    }
}
