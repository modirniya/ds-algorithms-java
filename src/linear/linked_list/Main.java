package linear.linked_list;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var linked_list = new LinkedList();
        linked_list.addFirst(12);
        linked_list.addLast(6);
        linked_list.addLast(7);
        linked_list.addFirst(1);
        linked_list.addFirst(43);
        linked_list.addFirst(33);
        System.out.println(linked_list.indexOf(6));
        System.out.println(Arrays.toString(linked_list.listToArray()));
        linked_list.reverse();
        System.out.println(linked_list.kthNode(4));
        //linked_list.deleteLast();
        System.out.print("[" + linked_list + "]");
    }

}


