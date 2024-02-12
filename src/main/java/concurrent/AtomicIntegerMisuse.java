package concurrent;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class AtomicIntegerMisuse {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final List<Integer> sharedList = new ArrayList<>();

    public void addToSharedListIfCounterLessThan(final int number) {
        // 이 조건으로 인해, 예상보다 더 많은 쓰레드가 들어올 수 있다.
        // 조건 검사와 incrementAndGet() 호출 사이에 원자적이지 않은 연산이 이루어지기 때문임.
        if (counter.get() < number) {
            sharedList.add(counter.incrementAndGet());
        }
    }

}
