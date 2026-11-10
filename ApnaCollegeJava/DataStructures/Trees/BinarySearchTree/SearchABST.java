package DataStructures.Trees.BinarySearchTree;

public class SearchABST {

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
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            // left subtree
            root.left = buildBST(root.left, val);
        } else {
            // right subtree
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    public static boolean searchBST(Node root, int key) { // time complexity = O(h)

        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        } else if(root.data > key) { // left subtree
            return searchBST(root.left, key);
        } else { // right subtree
            return searchBST(root.right, key);
        }
    }


    public static void main(String[] args) {
        int[] values = {8, 10, 5, 11, 14, 3, 6, 4, 1};

        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = buildBST(root, values[i]);
        }

        if(searchBST(root, 7)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }


    }
}
