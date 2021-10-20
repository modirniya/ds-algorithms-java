package linear.stacks;

public class ArrayStack {

    private int[] array;
    private int count;

    public ArrayStack() {
        array = new int[4];
        count = 0;
    }

    public void push(int entry) {
        if (isFull()) {
            extendArray();
        } else {
            array[count++] = entry;
        }
    }

    private void extendArray() {
        var extendedArray = new int[count * 2];
        System.arraycopy(array, 0, extendedArray, 0, array.length);
        array = extendedArray;
        System.out.println("Array Stack extended successfully...");
    }

    public int pop() {
        if (isNotEmpty())
            return array[--count];
        return -1;
    }

    public int peek() {
        if (isNotEmpty())
            return array[count];
        return -1;
    }

    public boolean isNotEmpty() {
        return count != 0;
    }

    private boolean isFull() {
        return count == array.length;
    }
}
