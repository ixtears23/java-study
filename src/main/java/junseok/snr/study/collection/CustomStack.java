package junseok.snr.study.collection;

import java.util.ArrayList;

public class CustomStack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.remove(stack.size() - 1);
    }
    public void push(T item) {
        stack.add(item);
    }

    public void print() {
        stack.forEach(System.out::println);
    }

    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("pop : " + stack.pop());
        stack.print();
        System.out.println("pop : " + stack.pop());
        stack.print();
        System.out.println("pop : " + stack.pop());
        stack.print();
        System.out.println("pop : " + stack.pop());
        stack.print();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        System.out.println("pop : " + stack.pop());
        stack.print();
        stack.push(4);
        stack.print();

    }
}
