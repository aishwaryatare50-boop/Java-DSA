package DataStructures.Trees.BinarySearchTree;

public class DeleteANodeinBST {

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

    public static void inorderTraversal(Node root) {
        if(root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + "  ");
        inorderTraversal(root.right);
    }

    public static boolean searchBST(Node root, int key) {

        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        } else if(root.data > key) {
            // left subtree
            return searchBST(root.left, key);
        } else {
            // right subtree
            return searchBST(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if(root == null) {
            return root;
        }
        // searching for node
        if(root.data > val) {
            root.left = delete(root.left, val);
        } else if(root.data < val) {
            root.right = delete(root.right, val);
        } else { // root.data == val
            // case-1(leaf node)
            if(root.left == null && root.right == null) {
                return null;
            }

            // case-2(1 child)
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // case-3(2 children)
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }

        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = buildBST(root, values[i]);
        }

        inorderTraversal(root);
        System.out.println();

        root = delete(root, 4);

        inorderTraversal(root);
        System.out.println();

        root = delete(root, 10);

        inorderTraversal(root);
        System.out.println();

        root = delete(root, 5);

        inorderTraversal(root);
        System.out.println();
    }
}
