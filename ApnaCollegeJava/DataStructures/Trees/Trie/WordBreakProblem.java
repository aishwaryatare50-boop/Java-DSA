/* Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation. 
Sample : 
words[] = {"i", "like", "sam", "samsung", "mobile", "ice"}
key = "ilikesamsung"
output: true
 */

package DataStructures.Trees.Trie;

public class WordBreakProblem {

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

    public static boolean searchTrie(String key) {
        Node temp = root;

        for(int i=0; i<key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            Node node = temp.children[idx];

            if(node == null) {
                return false;
            }

            if(i == key.length()-1 && node.endOfWord == false) {
                return false;
            }

            temp = temp.children[idx];
        }

        return true;
    }

    public static boolean wordBreak(String key) {
        if(key.length() == 0) {
            return true;
        }

        for(int i=1; i<= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);

            if(searchTrie(firstPart) && wordBreak(secondPart)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<words.length; i++) {
            buildTrie(words[i]);
        }

        String key = "ilikesamsung";

        System.out.println(wordBreak(key));

    }
}