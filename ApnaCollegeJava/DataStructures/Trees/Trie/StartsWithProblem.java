/* startsWithProblem
Create a function for a trie which checks if a previously inserted string word has the prefix or not.
 */

package DataStructures.Trees.Trie;

public class StartsWithProblem {
    public static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            this.children = new Node[26];
            for(int i=0; i<26; i++) {
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

    public static boolean startsWith(String prefix) {
        Node temp = root;
        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';

            if(temp.children[idx] == null) {
                return false;
            }

            temp = temp.children[idx];
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "app", "mango", "man", "woman"};

        for(int i=0; i<words.length; i++) {
            buildTrie(words[i]);
        }

        System.out.println(startsWith("app"));
        System.out.println(startsWith("moon"));
    }
}
