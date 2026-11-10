package DataStructures.Trees.BinaryTrees;

public class DiameterOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
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

        int heightOfLeftSubTree = heightOfTree(root.left);
        int heightOfRightSubTree = heightOfTree(root.right);

        return Math.max(heightOfLeftSubTree, heightOfRightSubTree) + 1;
    }
    
    // Approach-1

    public static int diameterOfTree(Node root) { // time complexity - O(n^2)
        if(root == null) {
            return 0;
        }

        int diameterOfLeftSubTree = diameterOfTree(root.left);
        int diameterOfRightSubTree = diameterOfTree(root.right);
        int diameterThroughRoot = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diameterThroughRoot, Math.max(diameterOfRightSubTree, diameterOfLeftSubTree));
    }

    // Approach - 2

    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameter2(Node root) {
        
        if(root == null) {
            return new TreeInfo(0,0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diameter1 = left.diameter;
        int diameter2 = right.diameter;
        int diameter3 = left.height + right.height + 1;

        int myDiameter = Math.max(Math.max(diameter1, diameter2), diameter3);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiameter);

        return myInfo;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        System.out.println(diameterOfTree(root));

        System.out.println(diameter2(root).diameter);
    }
}
