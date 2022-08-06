package junseok.snr.study.pattern.design.dynamicproxy;

public class Auditor {
    public void audit(String service, String extraData) {
        System.out.println(service);
        System.out.println(extraData);
    }
}
