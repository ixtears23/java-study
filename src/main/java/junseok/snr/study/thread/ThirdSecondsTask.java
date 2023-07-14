package junseok.snr.study.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThirdSecondsTask implements Task {

    @Override
    public void execute() {
        int count = 0;
        for (int i = 0; i < 2_000_000_000; i++) {
            for (int j = 0; j < 1_000_000_000; j++) {
                count++;
            }
        }
    }


}
