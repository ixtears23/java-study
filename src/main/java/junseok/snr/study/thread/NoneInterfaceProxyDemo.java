package junseok.snr.study.thread;

public class NoneInterfaceProxyDemo {
    public static void main(String[] args) {
        final ThirdSecondsTask thirdSecondsTask = new ThirdSecondsTask();
        final NoneInterfaceProxyTask task = new NoneInterfaceProxyTask(thirdSecondsTask);
        task.execute();
    }
}
