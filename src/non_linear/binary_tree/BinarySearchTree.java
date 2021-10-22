package non_linear.binary_tree;

import java.util.ArrayList;
import java.util.Objects;

public class BinarySearchTree {

    private class Node {
        private Integer value;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int entry) {
        final var entryNode = new Node(entry);
        if (root == null) {
            root = entryNode;
        } else {
            var curr = root;
            while (true) {
                if (curr.value > entry) {
                    if (curr.left == null) {
                        curr.left = entryNode;
                        break;
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = entryNode;
                        break;
                    }
                    curr = curr.right;
                }
            }
        }
    }

    public boolean find(int entry) {
        if (root == null) throw new IllegalStateException("no items in tree");
        var curr = root;
        while (true) {
            if (curr == null) return false;
            if (curr.value < entry) curr = curr.right;
            else if (curr.value > entry) curr = curr.left;
            else return true;
        }
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= getHeight(); i++)
            getNodesAtDistance(i);
    }

    public void swapRoot() {
        var temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var result = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, result);
        System.out.println("Nodes at k=" + distance + ": " + result);
        return result;
    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getMin() {
        if (root == null) throw new IllegalStateException("no items in tree");
        return getBinarySearchTreeMin(this.root);
    }

    public boolean validateBST() {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isEqual(BinarySearchTree anotherTree) {
        return isEqual(this.root, anotherTree.root);
    }

    private void traversePreOrder(Node curr) {
        // base condition
        if (curr == null) return;
        System.out.println(curr.value);
        traversePreOrder(curr.left);
        traversePreOrder(curr.right);
    }

    private void traverseInOrder(Node curr) {
        // base condition
        if (curr == null) return;
        traverseInOrder(curr.left);
        System.out.println(curr.value);
        traverseInOrder(curr.right);
    }

    private void traversePostOrder(Node curr) {
        // base condition
        if (curr == null) return;
        traversePostOrder(curr.left);
        traversePostOrder(curr.right);
        System.out.println(curr.value);
    }

    private void getNodesAtDistance(Node curr, int distance, ArrayList<Integer> list) {
        if (curr == null || distance < 0) return;
        if (distance == 0)
            list.add(curr.value);
        getNodesAtDistance(curr.left, distance - 1, list);
        getNodesAtDistance(curr.right, distance - 1, list);
    }

    private int getHeight(Node curr) {
        // base condition
        if (curr == null) return -1;
        return 1 + Math.max(
                getHeight(curr.left),
                getHeight(curr.right));
    }

    private int getBinarySearchTreeMin(Node curr) {
        // O(log n)
        // base condition
        if (curr.left == null) return curr.value;
        return getBinarySearchTreeMin(curr.left);
    }

    private int getBinaryTreeMin(Node curr) {
        // O(n)
        // base condition
        if (curr == null) return Integer.MAX_VALUE;
        return Math.min(
                curr.left == null ? curr.value : getBinaryTreeMin(curr.left),
                curr.right == null ? curr.value : getBinaryTreeMin(curr.right));
    }

    private boolean validateBST(Node curr, int min, int max) {
        if (curr == null) return true;
        var currValue = curr.value;
        if (currValue <= min || currValue >= max) return false;
        return validateBST(curr.left, min, currValue) &&
                validateBST(curr.right, currValue, max);
    }

    private boolean isEqual(Node curr1, Node curr2) {
        // base condition
        if (curr1 == null && curr2 == null) return true;

        if (curr1 != null && curr2 != null)
            return Objects.equals(curr1.value, curr2.value) &&
                    isEqual(curr1.left, curr2.left) &&
                    isEqual(curr1.right, curr2.right);
        return false;
    }


}










