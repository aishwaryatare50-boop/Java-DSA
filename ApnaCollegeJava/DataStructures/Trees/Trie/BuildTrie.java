package DataStructures.Trees.Trie;

public class BuildTrie {

    public static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            this.children = new Node[26]; // a to z
            for(int i=0; i<26; i++) {
                children[i] = null;
            }

            this.endOfWord = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node temp = root;

        for(int i=0; i<word.length(); i++) { // O(L)
            int idx = word.charAt(i) - 'a';

            if(temp.children[idx] == null) {
                // add new node
                temp.children[idx] = new Node();
            }

            if(i == word.length()-1) {
                temp.children[idx].endOfWord = true;
            }

            temp = temp.children[idx];
        }
    }

    public static void main(String[] args) {
        String[] words  = {"the", "a", "there", "their", "any"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
    }
}
