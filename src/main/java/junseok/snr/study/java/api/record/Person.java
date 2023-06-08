package junseok.snr.study.java.api.record;

public record Person(String name, int age) {
    public String greet() {
        return name + age;
    }
}
