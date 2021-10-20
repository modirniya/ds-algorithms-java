package linear.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] array;
    private int count;

    public PriorityQueue(int initialCapacity) {
        array = new int[initialCapacity];
        count = 0;
    }

    public void add(int entry) {
        if (isFull())
            extendCapacity();
        final var idx = shiftAsNecessaryToInsert(entry);
        array[idx] = entry;
        count++;
    }

    private int shiftAsNecessaryToInsert(int entry) {
        int idx;
        for (idx = count - 1; idx >= 0; idx--)
            if (array[idx] > entry)
                array[idx + 1] = array[idx];
            else
                break;
        return idx + 1;
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException("PQ is empty");
        return array[--count];
    }

    private void extendCapacity() {
        final var tempArray = new int[array.length * 2];
        System.arraycopy(array, 0, tempArray, 0, array.length);
        array = tempArray;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == array.length - 1;
    }

    @Override
    public String toString() {
        return "\nPriorityQueue{" +
                "\narray=" + Arrays.toString(array) +
                "\n, count=" + count +
                "\n}";
    }
}
