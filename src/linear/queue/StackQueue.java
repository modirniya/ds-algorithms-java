package linear.queue;

import linear.stack.Stack;

public class StackQueue {
    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;

    public StackQueue() {
        this.stackEnqueue = new Stack<>();
        this.stackDequeue = new Stack<>();
    }

    public void Enqueue(int value) {
        stackEnqueue.push(value);
    }

    public int dequeue() {
        if (stackEnqueue.isEmpty() && stackDequeue.isEmpty())
            throw new IllegalStateException("Queue is empty");
        if (stackDequeue.isEmpty())
            updateStackDequeue();
        return stackDequeue.pop();
    }

    private void updateStackDequeue() {
        while (!stackEnqueue.isEmpty())
            stackDequeue.push(stackEnqueue.pop());
    }

    @Override
    public String toString() {
        return "\nStackQueue{" +
                "\nstackEnqueue=" + stackEnqueue +
                "\nstackDequeue=" + stackDequeue +
                "\n}";
    }
}
