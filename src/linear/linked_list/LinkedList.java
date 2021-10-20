package linear.linked_list;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node head;
    private Node tail;

    private int size;

    private class Node {
        private final T value;
        private LinkedList<T>.Node next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public void addHead(T value) {
        size++;
        var node = new Node(value);
        if (isEmpty())
            head = tail = node;
        else {
            node.next = head;
            head = node;
        }
    }

    public void addTail(T value) {
        size++;
        var node = new Node(value);
        if (isEmpty())
            addHead(value);
        else {
            tail.next = node;
            tail = node;
        }
    }

    public T removeHead() {
        // [a -> b -> c]
        final T value = headValue();
        if (isEmpty()) throw new NoSuchElementException();
        size--;
        if (head == tail) {
            head = tail = null;
            return value;
        }
        Node afterHead = head.next; // [b -> c]
        head.next = null; // [a -> null]
        head = afterHead; // [b -> c]
        return value;
    }

    public void removeTail() {
        if (isEmpty()) throw new NoSuchElementException();
        size--;
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = getPreviousOf(tail);
        if (tail != null)
            tail.next = null;
    }

    public int indexOf(T target) {
        var index = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.value == target) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T target) {
        return indexOf(target) != -1;
    }

    private Node getPreviousOf(Node target) {
        Node curr = head;
        while (curr.next != null) {
            if (curr.next == target) return curr;
            curr = curr.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    public T[] listToArray() {
        final T[] array = (T[]) new Object[size];
        Node curr = head;
        for (int i = 0; i < size; i++) {
            array[i] = curr.value;
            curr = curr.next;
        }
        return array;
    }

    public void reverse() {
//        var values = listToArray();
//        tail = head = null;
//        for (int value : values) addFirst(value);
        if (isEmpty()) return;
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail = head;
        tail.next = null;
        head = prev;
    }

    public Node kthNode(int k) {
        if (isEmpty()) return null;
        Node bait = head;
        Node target = head;
        for (int i = 0; i < k - 1; i++) {
            if (bait.next == null) throw new NoSuchElementException();
            bait = bait.next;
        }

        while (bait != tail) {
            bait = bait.next;
            target = target.next;
        }
        return target;
        /*int distance = -k;
        while (bait != null) {
            bait = bait.next;
            if (distance == 0) {
                target = target.next;
            } else distance++;
        }
        return target;*/
    }

    public T headValue() {
        if (head != null)
            return head.value;
        return null;
    }

    public T tailValue() {
        if (tail != null)
            return tail.value;
        return null;
    }

    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder();
        Node current = head;
        while (current != null) {
            strResult.append(current.value).append(",");
            current = current.next;
        }
        return strResult + " size: " + size;
    }
}




