package junseok.snr.study.thread;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class ThirdSecondsTaskTest {

    /**
     * 여기서 평균 3초의 기준은 다음과 같음
     * 20번 반복해서 실행했을 때, 실행시간 -> 2500 <= X <= 3500  millis
     */
    @RepeatedTest(10)
    void executeTest() {
        final long startTime = System.currentTimeMillis();
        Task task = new ProxyTask(new ThirdSecondsTask());
        task.execute();
        final long endTime = System.currentTimeMillis();

        final long executeTime = endTime - startTime;

        assertThat(executeTime).isGreaterThan(2500L)
                .isLessThan(3500L);
    }
}