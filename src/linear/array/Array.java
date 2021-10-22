package linear.array;

import java.util.Arrays;

public class Array {

    private int count;
    private String[] array;

    public Array(int initialCapacity) {
        array = new String[initialCapacity];
        count = 0;
    }

    public void insert(String entry) {
        if (entry == null) throw new IllegalArgumentException("null as entry");
        if (isFull()) expandCapacity();
        array[count++] = entry;
    }

    public void removeAt(int index) {
        errorIfInvalid(index);
        int i;
        for (i = index; i < count - 1; i++)
            array[i] = array[i + 1];
        array[i] = null;
        count--;
    }

    public void remove() {
        array[--count] = null;
    }

    public boolean isFull() {
        return count == array.length;
    }

    private void errorIfInvalid(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException("invalid index");
    }

    private void expandCapacity() {
        final String[] expandedArray = new String[array.length * 2];
        System.arraycopy(array, 0, expandedArray, 0, array.length);
        array = expandedArray;
    }

    @Override
    public String toString() {
        return "\nArray{" +
                "\ncount=" + count +
                "\n, array=" + Arrays.toString(array) +
                "\n}";
    }
}
