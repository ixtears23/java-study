package junseok.snr.nested;

public class NestedClass {
    public int publicVar;
    protected int protectedVar;
    private int privateVar;
    int defaultVar;


    public class InnerPublicClass {
        public int publicVar;
        protected int protectedVar;
        private int privateVar;
        int defaultVar;

        public void nothing() {

            int publicVar = new NestedClass().publicVar;
            int protectedVar = new NestedClass().protectedVar;
            int privateVar = new NestedClass().privateVar;
            int defaultVar = new NestedClass().defaultVar;

        }
    }

    protected class InnerProtectedClass {
        public int publicVar;
        protected int protectedVar;
        private int privateVar;
        int defaultVar;

        public void nothing() {

            int publicVar = new NestedClass().publicVar;
            int protectedVar = new NestedClass().protectedVar;
            int privateVar = new NestedClass().privateVar;
            int defaultVar = new NestedClass().defaultVar;

        }
    }

    class InnerDefaultClass {
        public int publicVar;
        protected int protectedVar;
        private int privateVar;
        int defaultVar;

        public void nothing() {

            int publicVar = new NestedClass().publicVar;
            int protectedVar = new NestedClass().protectedVar;
            int privateVar = new NestedClass().privateVar;
            int defaultVar = new NestedClass().defaultVar;

        }
    }

    private class InnerPrivateClass {
        public int publicVar;
        protected int protectedVar;
        private int privateVar;
        int defaultVar;

        public void nothing() {

            int publicVar = new NestedClass().publicVar;
            int protectedVar = new NestedClass().protectedVar;
            int privateVar = new NestedClass().privateVar;
            int defaultVar = new NestedClass().defaultVar;

        }
    }

    public static class StaticInnerPublicClass {
        public int publicVar;
        protected int protectedVar;
        private int privateVar;
        int defaultVar;
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
