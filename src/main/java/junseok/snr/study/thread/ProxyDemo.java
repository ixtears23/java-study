package junseok.snr.study.thread;

public class ProxyDemo {
    public static void main(String[] args) {

        final ThirdSecondsTask thirdSecondsTask = new ThirdSecondsTask();
        final ProxyTask proxyTask = new ProxyTask(thirdSecondsTask);
        proxyTask.execute();
    }
}
