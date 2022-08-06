package junseok.snr.study.pattern.design.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
    public static void main(String[] args) {
        Auditor auditor = new Auditor();
        Calculator real = new CalculatorImpl();
        InvocationHandler handler = new AuditingInvocationHandler(auditor, real);
        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), new Class[] { Calculator.class }, handler
        );

        final int addResult = real.add(2, 2);
        System.out.println("real.add result = " + addResult);
        System.out.println("============================");
        final int proxyResult = proxy.add(2, 2);
        System.out.println("proxy.add result = " + proxyResult);
    }
}
