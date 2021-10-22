package non_linear.binary_tree;

public class Main {
    public static void main(String[] args) {
        var bst = initializeBST();
        var bst2 = initializeBST();
        System.out.println("Pre-Order");
        bst.traversePreOrder();
        System.out.println("In-Order");
        bst.traverseInOrder();
        System.out.println("Post-Order");
        bst.traversePostOrder();
        System.out.println("Level-Order");
        bst.traverseLevelOrder();
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Minimum: " + bst.getMin());
        System.out.println("is equal: " + bst.isEqual(bst2));
        bst.swapRoot();
        bst.swapRoot();
        System.out.println("validateBST: " + bst.validateBST());
        bst.getNodesAtDistance(1);
    }

    private static BinarySearchTree initializeBST() {
        var bst2 = new BinarySearchTree();
        bst2.insert(4);
        bst2.insert(5);
        bst2.insert(34);
        bst2.insert(8);
        bst2.insert(3);
        return bst2;
    }
}
