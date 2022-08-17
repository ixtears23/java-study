package junseok.snr.study.proxy.cglib;

import static org.assertj.core.api.Assertions.assertThat;

import net.sf.cglib.proxy.Mixin;
import org.junit.jupiter.api.Test;

class MixInTest {

    @Test
    void nothing() {
        Mixin mixin = Mixin.create(
                new Class[]{ Interface1.class, Interface2.class, MixinInterface.class },
                new Object[]{ new Class1(), new Class2() }
        );
        MixinInterface mixinDelegate = (MixinInterface) mixin;

        assertThat(mixinDelegate.first()).isEqualTo("first behaviour");
        assertThat(mixinDelegate.first()).isEqualTo("first behaviour");
    }
}
