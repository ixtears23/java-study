package junseok.snr.study.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyTask implements Task {
    private final Task task;

    public ProxyTask(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        final long startTime = System.currentTimeMillis();
        task.execute();
        final long endTime = System.currentTimeMillis();
        log.info(">>>>> execute time : {}", endTime - startTime);
    }
}
