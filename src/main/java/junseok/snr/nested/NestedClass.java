package junseok.snr.nested;

public class NestedClass {
    public int publicVar;
    protected int protectedVar;
    private int privateVar;
    int defaultVar;


    public class InnerPublicClass {

        public void nothing() {

            int publicVar = new NestedClass().publicVar;
            int protectedVar = new NestedClass().protectedVar;
            int privateVar = new NestedClass().privateVar;
            int defaultVar = new NestedClass().defaultVar;

        }
    }

    protected class InnerProtectedClass {
        public void nothing() {

            int publicVar = new NestedClass().publicVar;
            int protectedVar = new NestedClass().protectedVar;
            int privateVar = new NestedClass().privateVar;
            int defaultVar = new NestedClass().defaultVar;

        }
    }

    class InnerDefaultClass {
        public void nothing() {

            int publicVar = new NestedClass().publicVar;
            int protectedVar = new NestedClass().protectedVar;
            int privateVar = new NestedClass().privateVar;
            int defaultVar = new NestedClass().defaultVar;

        }
    }

    private class InnerPrivateClass {
        public void nothing() {

            int publicVar = new NestedClass().publicVar;
            int protectedVar = new NestedClass().protectedVar;
            int privateVar = new NestedClass().privateVar;
            int defaultVar = new NestedClass().defaultVar;

        }
    }

    public static class StaticInnerPublicClass {

    }

    protected static class StaticInnerProtectedClass {

    }

    private static class StaticInnerPrivateClass {}

    static class StaticInnerDefaultClass {

    }

    public static void main(String[] args) {
        new NestedClass.StaticInnerPrivateClass();  // static private class는 동일 클래스 내에서만 인스턴스화 해서 사용할 수 있음.
    }



}
