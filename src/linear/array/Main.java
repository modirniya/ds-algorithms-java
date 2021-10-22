package linear.array;

public class Main {

    private static final Array array = new Array(4);

    public static void main(String[] args) {
        array.insert("parham");
        array.insert("ali");
        array.insert("behzad");
        array.insert("mostafa");
        array.insert("mehrad");
        array.insert("peyman");
        System.out.println(array);
        array.removeAt(2);
        System.out.println(array);
        array.remove();
        System.out.println(array);
    }
}
