package concurrent;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicBoolean;

public class VarHandleDemo {
    private int value = 123;

    public int getValue() {
        return value;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        VarHandle vh = MethodHandles.lookup().in(VarHandleDemo.class)
                .findVarHandle(VarHandleDemo.class, "value", int.class);

        VarHandleDemo varHandleDemo = new VarHandleDemo();
        System.out.println(vh.get(varHandleDemo));
        System.out.println(varHandleDemo.getValue());

        vh.set(varHandleDemo, 456);
        System.out.println(vh.get(varHandleDemo));
        System.out.println(varHandleDemo.getValue());

    }

}
