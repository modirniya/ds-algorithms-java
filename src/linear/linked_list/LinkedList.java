package linear.linked_list;

import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;

    private int count = 0;

    private class Node {
        private String value;
        private Node next;

        public Node() {
        }

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "\nvalue='" + value + '\'' +
                    '}';
        }
    }

    public void add(String entry) {
        if (entry == null) raiseErrorNullEntry();
        if (isEmpty())
            initialFirstNode(entry);
        else
            head = new Node(entry, head);
        count++;
    }

    public void addTail(String entry) {
        if (entry == null) raiseErrorNullEntry();

        if (isEmpty())
            initialFirstNode(entry);
        else {
            tail.next = new Node(entry);
            tail = tail.next;
        }
        count++;
    }

    public void remove() {
        if (isEmpty()) raiseErrorEmptyList();
        count--;
        if (head == tail) {
            head = tail = null;
            return;
        }
        final var nextHead = head.next;
        head.next = null;
        head = nextHead;
    }

    public void removeTail() {
        if (isEmpty()) raiseErrorEmptyList();
        count--;
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = getPreviousOf(tail);
        if (tail != null) tail.next = null;
    }

    public int indexOf(String targetValue) {
        if (targetValue == null) raiseErrorNullEntry();
        if (isEmpty()) raiseErrorEmptyList();
        var curr = head;
        var index = 0;
        while (curr != null) {
            if (curr.value.equals(targetValue))
                return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public boolean contains(String targetValue) {
        if (targetValue == null) raiseErrorNullEntry();
        if (isEmpty()) raiseErrorEmptyList();
        var curr = head;
        while (curr != null) {
            if (curr.value.equals(targetValue)) return true;
            curr = curr.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private Node getPreviousOf(Node target) {
        var curr = head;
        while (curr != null && curr.next != target)
            curr = curr.next;
        return curr;
    }

    private void initialFirstNode(String entry) {
        head = tail = new Node(entry);
    }

    private void raiseErrorEmptyList() {
        throw new NoSuchElementException("linked list is empty...");
    }

    private void raiseErrorNullEntry() {
        throw new IllegalArgumentException("null as argument");
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "\nhead=" + head +
                "\n, tail=" + tail +
                "\n, count=" + count +
                '}';
    }
}
