package junseok.snr.study.var;

public class OverflowTest {
    public static void main(String[] args) {
        // byte 오버플로우 테스트 (1바이트: -128 ~ 127)
        byte byteMax = 127;
        byte byteOverflow = (byte) (byteMax + 1);
        System.out.println("byte 오버플로우:");
        System.out.println("최대값: " + byteMax);
        System.out.println("최대값 + 1: " + byteOverflow);
        System.out.println();


        // short 오버플로우 테스트 (2바이트: -32,768 ~ 32,767)
        short shortMax = 32767;
        short shortOverflow = (short) (shortMax + 1);
        System.out.println("short 오버플로우:");
        System.out.println("최대값: " + shortMax);
        System.out.println("최대값 + 1: " + shortOverflow);
        System.out.println();

        // int 오버플로우 테스트 (4바이트: -2,147,483,648 ~ 2,147,483,647)
        int intMax = 2147483647;
        int intOverflow = intMax + 1;
        System.out.println("int 오버플로우:");
        System.out.println("최대값: " + intMax);
        System.out.println("최대값 + 1: " + intOverflow);
        System.out.println();

        // long 오버플로우 테스트 (8바이트: -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807)
        long longMax = 9223372036854775807L;
        long longOverflow = longMax + 1;
        System.out.println("long 오버플로우:");
        System.out.println("최대값: " + longMax);
        System.out.println("최대값 + 1: " + longOverflow);
        System.out.println();

        // float 오버플로우 테스트 (4바이트, 부동소수점)
        float floatMax = Float.MAX_VALUE;
        float floatOverflow = floatMax * 2; // 무한대 (Infinity)로 변환
        System.out.println("float 오버플로우:");
        System.out.println("최대값: " + floatMax);
        System.out.println("최대값 * 2: " + floatOverflow);
        System.out.println();

        // double 오버플로우 테스트 (8바이트, 부동소수점)
        double doubleMax = Double.MAX_VALUE;
        double doubleOverflow = doubleMax * 2; // 무한대 (Infinity)로 변환
        System.out.println("double 오버플로우:");
        System.out.println("최대값: " + doubleMax);
        System.out.println("최대값 * 2: " + doubleOverflow);
        System.out.println();
    }
}
