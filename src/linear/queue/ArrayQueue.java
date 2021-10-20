package linear.queue;

import java.util.Arrays;

public class ArrayQueue {
    private final int[] array;
    private int head;
    private int tail;
    private int count;

    public ArrayQueue() {
        array = new int[6];
        head = tail = 0;
        count = 0;
    }

    public void enqueue(int value) {
        if (isFull())
            throw new IllegalStateException("Queue is full,,,");
        array[tail++] = value;
        tail %= array.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        var result = array[head];
        array[head++] = 0;
        head %= array.length;
        count--;
        return result;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        return array[head];
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == array.length + 1;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + Arrays.toString(array) +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
