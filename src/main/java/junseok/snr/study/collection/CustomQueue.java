package junseok.snr.study.collection;

import java.util.ArrayList;

public class CustomQueue<T> {
    private final ArrayList<T> queue;

    public CustomQueue() {
        queue = new ArrayList<>();
    }

    public void enQueue(T data) {
        queue.add(data);
    }

    public T deQueue() {
        if (queue.isEmpty()) return null;
        return queue.remove(0);
    }

    public void printQueue() {
        for (T t : queue) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        queue.printQueue();

        System.out.println("=== dequeue : " + queue.deQueue());
        System.out.println("=== dequeue : " + queue.deQueue());
        System.out.println("=== dequeue : " + queue.deQueue());
        System.out.println("=== dequeue : " + queue.deQueue());
        System.out.println("=== dequeue : " + queue.deQueue());

        queue.printQueue();
        queue.enQueue(3);
        queue.enQueue(2);
        queue.enQueue(1);
        queue.printQueue();
    }
}
