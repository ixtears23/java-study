package junseok.snr.study.proxy.cglib;

import static org.assertj.core.api.Assertions.assertThat;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonServiceProxyMethodSignatureTest {

    private PersonService proxy;

    @BeforeAll
    void setUp() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello Tom!";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });
        proxy = (PersonService) enhancer.create();
    }

    @Test
    void sayHelloTest() {
        final String hello = proxy.sayHello(null);
        int lengthOfNum = proxy.lengthOfName("Mary");

        assertThat(lengthOfNum).isEqualTo(4);
    }

}