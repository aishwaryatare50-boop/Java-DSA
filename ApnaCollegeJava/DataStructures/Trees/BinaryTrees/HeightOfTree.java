package DataStructures.Trees.BinaryTrees;

public class HeightOfTree {
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

    public static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSubtreeHeight = heightOfTree(root.left);
        int rightSubtreeHeight = heightOfTree(root.right);

        int heightOfSubTree = Math.max(leftSubtreeHeight, rightSubtreeHeight);

        return heightOfSubTree + 1;
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        System.out.println(heightOfTree(root));
    }
}
