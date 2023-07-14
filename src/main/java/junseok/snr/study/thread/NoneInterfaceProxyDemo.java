package junseok.snr.study.thread;

public class NoneInterfaceProxyDemo {
    public static void main(String[] args) {
        final Task thirdSecondsTask = new ThirdSecondsTask();
        final Task task = new NoneInterfaceProxyTask(thirdSecondsTask);
        task.execute();
    }
}
