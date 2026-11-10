package DataStructures.Trees.BinaryTrees;

import java.util.Queue;
import java.util.LinkedList;

public class SumOfNodesAtKthLevel {
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

    public static int sumOfNodesAtKthLevel(Node root, int k) {

        if(root == null || k <= 0) {
            return 0;
        }

        if(k == 1) {
            return root.data;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        int sumOfNodes = 0;

        while(!q.isEmpty()) {
            Node currNode = q.remove();

            if(currNode == null) {
                if(level == k) {
                    return sumOfNodes;
                }
                level++;
                sumOfNodes = 0;

                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                sumOfNodes += currNode.data;

                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        System.out.println(sumOfNodesAtKthLevel(root, 3));

    }
}
