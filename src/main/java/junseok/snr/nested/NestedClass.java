package junseok.snr.nested;

public class NestedClass {
    public int publicVar;
    protected int protectedVar;
    private int privateVar;
    int defaultVar;


    public class InnerPublicClass {

        public void nothing() {
            System.out.println(publicVar);
            System.out.println(protectedVar);
            System.out.println(privateVar);
            System.out.println(defaultVar);

        }
    }

    protected class InnerProtectedClass {
        public int publicVar;
        protected int protectedVar;
        private int privateVar;
        int defaultVar;

        public void nothing() {

            int instancePublicVar = new NestedClass().publicVar;
            int instanceProtectedVar = new NestedClass().protectedVar;
            int instancePrivateVar = new NestedClass().privateVar;
            int instanceDefaultVar = new NestedClass().defaultVar;
            System.out.println(publicVar);
            System.out.println(protectedVar);
            System.out.println(privateVar);
            System.out.println(defaultVar);

        }
    }

    class InnerDefaultClass {
        public int publicVar;
        protected int protectedVar;
        private int privateVar;
        int defaultVar;

        public void nothing() {
            System.out.println(publicVar);
            System.out.println(protectedVar);
            System.out.println(privateVar);
            System.out.println(defaultVar);

        }
    }

    private class InnerPrivateClass {
        public int publicVar;
        protected int protectedVar;
        private int privateVar;
        int defaultVar;

        public void nothing() {

            System.out.println(publicVar);
            System.out.println(protectedVar);
            System.out.println(privateVar);
            System.out.println(defaultVar);
        }
    }

    public static class StaticInnerPublicClass {
        public int publicVar;
        protected int protectedVar;
        private int privateVar;
        int defaultVar;
    }

    protected static class StaticInnerProtectedClass {

        public static void main(String[] args) {
            NestedClass nestedClass = new NestedClass();
            System.out.println(nestedClass.publicVar);
            System.out.println(nestedClass.protectedVar);
            System.out.println(nestedClass.privateVar);
            System.out.println(nestedClass.defaultVar);
        }
    }

    private static class StaticInnerPrivateClass {}

    static class StaticInnerDefaultClass {

    }

    public static void main(String[] args) {
        new NestedClass.StaticInnerPrivateClass();  // static private class는 동일 클래스 내에서만 인스턴스화 해서 사용할 수 있음.
    }



}
