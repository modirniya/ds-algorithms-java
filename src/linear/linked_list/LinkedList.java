package linear.linked_list;

import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;

    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public void addFirst(int value) {
        size++;
        var node = new Node(value);
        if (isEmpty())
            head = tail = node;
        else {
            node.next = head;
            head = node;
        }
    }

    public void addLast(int value) {
        size++;
        var node = new Node(value);
        if (tail == null)
            addFirst(value);
        else {
            tail.next = node;
            tail = node;
        }
    }

    public void removeFirst() {
        // [a -> b -> c]
        if (isEmpty()) throw new NoSuchElementException();
        size--;
        if (head == tail) {
            head = tail = null;
            return;
        }
        var afterHead = head.next; // [b -> c]
        head.next = null; // [a -> null]
        head = afterHead; // [b -> c]
    }

    public void removeLast() {
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

    public int indexOf(int target) {
        var index = 0;
        var curr = head;
        while (curr != null) {
            if (curr.value == target) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int target) {
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

    private boolean isEmpty() {
        return head == null;
    }

    public int[] listToArray() {
        int[] array = new int[size];
        var curr = head;
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
        var prev = head;
        var curr = head.next;
        while (curr != null) {
            var next = curr.next;
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
        var bait = head;
        var target = head;
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

    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder();
        var current = head;
        while (current != null) {
            strResult.append(current.value).append(",");
            current = current.next;
        }
        return strResult.toString() + " size: " + size;
    }
}




