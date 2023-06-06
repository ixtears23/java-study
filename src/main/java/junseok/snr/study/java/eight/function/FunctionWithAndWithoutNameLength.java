package junseok.snr.study.java.eight.function;

import java.util.function.Function;

public class FunctionWithAndWithoutNameLength {

    public int getNameLength(String name) {
        return name.length();
    }

    public Function<String, Integer> getNameLengthFunction() {
        return String::length;
    }
}
