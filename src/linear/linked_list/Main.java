package linear.linked_list;

public class Main {
    public static void main(String[] args) {
        var ll = new LinkedList();
        ll.add("Parham");
        ll.add("Peyman");
        ll.addTail("Neda");
        ll.add("Emen");
        ll.add("Behzad");
        ll.addTail("Mahsa");
        ll.removeTail();
        ll.remove();
        System.out.println(ll);
        System.out.println(ll.indexOf("Parham"));
        System.out.println(ll.contains("Parham"));
    }

}


