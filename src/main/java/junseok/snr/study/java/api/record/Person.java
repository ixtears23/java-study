package junseok.snr.study.java.api.record;

public record Person(String name, int age) {
    public String greet() {
        return "안녕!, 나는 " + name + "이라고 해. 내 나이는 " + age + "이야";
    }
}
