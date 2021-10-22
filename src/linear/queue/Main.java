package linear.queue;

import linear.stack.Stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        final var pq = new PriorityQueue(4);
        pq.add( 15);
        pq.add( 30);
        pq.add( 25);
        pq.add( 15);
        pq.add( 45);
        pq.add( 5);
        System.out.println(pq);
    }

    private static void stackQueueDriver() {
        final var stackQueue = new StackQueue();
        for (int i = 1; i < 7; i++)
            stackQueue.Enqueue(i * 10);
        System.out.println(stackQueue);
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue);
    }

    private static void reverseQueueDriver() {
        final Queue<Integer> queue = new ArrayDeque<>();
        final Stack<Integer> stack = new Stack<>();
        System.out.println("Queue: " + queue);
        reverseQueue(queue, stack);
        System.out.println("Queue: " + queue);
    }

    private static void arrayQueueDriver() {
        final ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 1; i < 6; i++)
            arrayQueue.enqueue(i * 10);
        for (int i = 1; i < 2; i++)
            arrayQueue.dequeue();
        for (int i = 1; i < 4; i++)
            arrayQueue.enqueue(i * 100);
        System.out.println(arrayQueue);
    }

    private static void reverseQueue(
            Queue<Integer> queue, Stack<Integer> stack) {
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        System.out.println("Stack: " + stack);
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
