package DataStructures.Trees.BinarySearchTree;

public class PrintInRange {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBST(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        if(root.data > val) {
            root.left = buildBST(root.left, val);
        } else {
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    public static void printInRange(Node root, int X, int Y) {

        if(root == null) {
            return;
        }

        // Case-1
        if(root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + "  ");
            printInRange(root.right, X, Y);
        } else if(root.data > Y) { // Case-2
            printInRange(root.left, X, Y);
        } else { // Case-3 root.data <= X
            printInRange(root.right, X, Y);
        }

    }
    

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = buildBST(root, values[i]);
        }

        printInRange(root, 3, 12);
    }
}
