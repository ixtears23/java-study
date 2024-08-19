package junseok.snr.study.var;

public class StringPoolInternSample {

    public static void main(String[] args) throws InterruptedException {

        String a = "newstring";
        final String s = new String("newstring");
        System.out.println(a == s);

        final String intern = s.intern();
        System.out.println(a == intern);


        String b = "newstring";
        System.out.println(a == b);
        System.out.println(intern == b);
    }
}
