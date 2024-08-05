package junseok.snr.nested;

public class NestedClientClass {

    public static void main(String[] args) {

        NestedClass.InnerPublicClass innerPublicClass = new NestedClass().new InnerPublicClass();
        NestedClass.InnerProtectedClass innerProtectedClass = new NestedClass().new InnerProtectedClass();
        NestedClass.InnerDefaultClass innerDefaultClass = new NestedClass().new InnerDefaultClass();

        innerPublicClass.defaultVar = 0;

        NestedClass.StaticInnerPublicClass staticInnerPublicClass = new NestedClass.StaticInnerPublicClass();
        NestedClass.StaticInnerProtectedClass staticInnerProtectedClass = new NestedClass.StaticInnerProtectedClass();
        NestedClass.StaticInnerDefaultClass staticInnerDefaultClass = new NestedClass.StaticInnerDefaultClass();
        // private static 클래스는 사용할 수 없음.

        staticInnerPublicClass.defaultVar = 0;
        staticInnerPublicClass.publicVar = 0;
    }
}
