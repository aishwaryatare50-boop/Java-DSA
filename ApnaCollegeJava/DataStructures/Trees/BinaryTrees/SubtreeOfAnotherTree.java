package DataStructures.Trees.BinaryTrees;

public class SubtreeOfAnotherTree {
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

    public static class BinaryTree {
        int idx = -1;

        public Node buildTree(int[] nodes) {
            idx++;

            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    } 

    public static boolean isIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }

        if(root == null || subRoot == null) {
            return false;
        }

        if(root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }

        return false;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(subRoot == null) {
            return true;
        }

        if(root == null) {
            return false;
        }

        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static void main(String[] args) {
        int[] nodes1 = {9, 7, 8, -1, -1, 1, 2, -1, -1, 3, -1, -1, 4, 5, -1, -1, 6, -1, -1};
        int[] nodes2 = {1, 2, -1, -1, 3, -1, -1};

        BinaryTree tree = new BinaryTree();
        BinaryTree Subtree = new BinaryTree();

        Node root = tree.buildTree(nodes1);
        Node subRoot = Subtree.buildTree(nodes2);

        System.out.println(isSubtree(root, subRoot));
        
    }
}
