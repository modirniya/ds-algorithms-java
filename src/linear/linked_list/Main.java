package linear.linked_list;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var linked_list = new LinkedList<String>();
        linked_list.addHead("a");
        linked_list.addTail("b");
        linked_list.addTail("c");
        linked_list.addHead("d");
        linked_list.addHead("e");
        linked_list.addHead("f");
        System.out.println(linked_list.indexOf("6"));
        System.out.println(Arrays.toString(linked_list.listToArray()));
        linked_list.reverse();
        System.out.println(linked_list.kthNode(4));
        //linked_list.deleteLast();
        System.out.print("[" + linked_list + "]");
    }

}


