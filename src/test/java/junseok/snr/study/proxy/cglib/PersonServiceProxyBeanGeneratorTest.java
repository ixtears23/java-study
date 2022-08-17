package junseok.snr.study.proxy.cglib;

import static org.assertj.core.api.Assertions.assertThat;

import net.sf.cglib.beans.BeanGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class PersonServiceProxyBeanGeneratorTest {

    private static Object myBean;
    private static Method getter;

    @BeforeAll
    static void setUp() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();

        beanGenerator.addProperty("name", String.class);
        myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "some string value set by a cglib");

        getter = myBean.getClass().getMethod("getName");
    }

    @Test
    void beanGeneratorTest() throws InvocationTargetException, IllegalAccessException {
        assertThat(getter.invoke(myBean)).isEqualTo("some string value set by a cglib");
    }
}
