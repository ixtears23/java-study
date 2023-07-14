package junseok.snr.study.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoneInterfaceProxyTask implements Task {
    private final Task task;

    public NoneInterfaceProxyTask(Task task) {
        this.task = task;
    }

    public void execute() {
        final long startTime = System.currentTimeMillis();
        task.execute();
        final long endTime = System.currentTimeMillis();
        log.info(">>>>> execute time : {}", endTime - startTime);
    }
}
