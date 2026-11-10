package DataStructures.Trees.Trie;

public class CountUniqueSubstrings {

    public static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            this.children = new Node[26];
            for(int i=0; i<26; i++) {
                this.children[i] = null;
            }

            this.endOfWord = false;
        }
    }

    public static Node root = new Node();

    public static void buildTrie(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if(temp.children[idx] == null) {
                temp.children[idx] = new Node();
            }

            if(i == word.length()-1) {
                temp.children[idx].endOfWord = true;
            }

            temp = temp.children[idx];
        }
    }

    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String str = "ababa";

        for(int i=0; i<str.length(); i++) {
            String suffix = str.substring(i);
            buildTrie(suffix);
        }

        System.out.println(countNodes(root));
    }
}
