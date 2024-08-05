package junseok.snr.nested;

public class NestedClientClass {

    public static void main(String[] args) {

        new NestedClass.StaticInnerPublicClass();
        new NestedClass.StaticInnerProtectedClass();
        new NestedClass.StaticInnerDefaultClass();
        // private static 클래스는 사용할 수 없음.
    }
}
