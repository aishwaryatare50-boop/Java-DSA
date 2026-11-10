package DataStructures.Trees.Trie;

public class SearchTrie {

    public static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            this.children = new Node[26];
            for(int i=0; i<children.length; i++) {
                children[i] = null;
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

    public static boolean searchTrie(String key) { // Time Complexity = O(L); L = key length
        Node temp = root;
        for(int i=0; i<key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            Node node = temp.children[idx];

            if( node == null) {
                return false;
            }

            if(i == key.length()-1 && node.endOfWord == false) {
                return false;
            }

            temp = temp.children[idx];
        }

        return true;
    } 
    public static void main(String[] args) {
        String[] words  = {"the", "a", "there", "their", "any"};
        for(int i=0; i<words.length; i++) {
            buildTrie(words[i]);
        }

        System.out.println(searchTrie("their")); // true
        System.out.println(searchTrie("thor")); // false
        System.out.println(searchTrie("an")); // false
    }
}
