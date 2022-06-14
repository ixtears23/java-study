package junseok.snr.study.pattern.design.singleton;

public class DemoSingleThread {
    public static void main(String[] args) {
        System.out.println("같은 값이 보이면 Singleton이 재사용된 것!!" +
                "다른 값이 보이면 두개의 Singleton이 생성된 것" +
                "RESULT:\n");
        final Singleton singleton = Singleton.getInstance("FOO");
        final Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);

    }
}
