package junseok.snr.study.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThirdSecondsTask {

    public void execute() {
        final long startTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 2_000_000_000; i++) {
            for (int j = 0; j < 1_000_000_000; j++) {
                count++;
            }
        }

        final long endTime = System.currentTimeMillis();
        log.info(">>>>> loopCount : {}, execute time : {}", count, endTime - startTime);
    }



}
