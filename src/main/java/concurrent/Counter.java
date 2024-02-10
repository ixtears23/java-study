package concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        log.info("=== count : {}", this.count);
        return this.count;
    }
}
