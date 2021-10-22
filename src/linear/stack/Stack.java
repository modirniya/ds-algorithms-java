package linear.stack;

import linear.linked_list.GenericLinkedList;

public class Stack<T> {
    final GenericLinkedList<T> dataset = new GenericLinkedList<>();

    public void push(T value) {
        dataset.add(value);
    }

    public T pop() {
        return dataset.removeHead();
    }

    public T peek() {
        return dataset.value();
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
