package junseok.snr.study.thread;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class ThirdSecondsTaskTest {

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