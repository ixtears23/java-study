package junseok.snr.study;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class MethodReference {
    @RequiredArgsConstructor
    public static class Person {
        @Getter
        private final String name;

        public boolean compareTo(Person o) {
            return o.name.compareTo(name) > 0;
        }

    }

    public static void print(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) {

        Consumer<String> staticPrint = MethodReference::print;
        var target = new Person("Junseok");

        Stream.of("Junseok", "Jane", "Tale", "Mon")
                .map(Person::new)
                .filter(target::compareTo)
                .map(Person::getName)
                .forEach(staticPrint);
    }
}
