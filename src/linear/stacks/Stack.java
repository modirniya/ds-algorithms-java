package linear.stacks;

import linear.linked_list.LinkedList;

public class Stack<T> {
    final LinkedList<T> dataset = new LinkedList<>();

    public void push(T value) {
        dataset.addHead(value);
    }

    public T pop() {
        return dataset.removeHead();
    }

    public T peek() {
        return dataset.headValue();
    }

    public boolean isEmpty() {
        return dataset.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack{" +
                "dataset=" + dataset +
                '}';
    }
}
