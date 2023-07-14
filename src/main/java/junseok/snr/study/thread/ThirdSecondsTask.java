package junseok.snr.study.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class ThirdSecondsTask implements Task {

    @Override
    public void execute() {
        for (int i = 0; i < 240_000_000; i++) {
            new Random(10).nextInt();
        }
    }

}
