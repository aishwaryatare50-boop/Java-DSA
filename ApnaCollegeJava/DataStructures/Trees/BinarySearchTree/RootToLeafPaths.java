package DataStructures.Trees.BinarySearchTree;

import java.util.ArrayList;

public class RootToLeafPaths {
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

    public static void printRootToLeafPaths(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data);

        // leaf
        if(root.left == null && root.right == null) {
            System.out.println(path);
        } else { // non-leaf node
            printRootToLeafPaths(root.left, path);
            printRootToLeafPaths(root.right, path);
        }
        path.remove(path.size()-1);
    }
    
    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = buildBST(root, values[i]);
        }

        printRootToLeafPaths(root, new ArrayList<>());
    }
}
