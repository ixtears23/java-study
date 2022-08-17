package junseok.snr.study.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonServiceProxySameValueTest {

    private PersonService proxy;

    @BeforeAll
    void setUp() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!");
        proxy = (PersonService) enhancer.create();
    }

    @Test
    void sayHelloTest() {
        final String hello = proxy.sayHello(null);

        assertThat(hello).isEqualTo("Hello Tom!");
    }

}
