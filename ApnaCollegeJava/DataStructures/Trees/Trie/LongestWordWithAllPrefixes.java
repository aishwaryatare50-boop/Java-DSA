package DataStructures.Trees.Trie;

public class LongestWordWithAllPrefixes {
    static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            children = new Node[26];
            for(int i=0; i<26; i++) {
                children[i] = null;
            }

            endOfWord = false;
        }
    }

    static Node root = new Node();

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

    public static String answer = "";

    public static void longestWordWithAllPrefixes(Node root, StringBuilder temp) {
        if(root == null) {
            return;
        }

        for(int i=0; i<26; i++) {
            if(root.children[i] != null && root.children[i].endOfWord == true) {
                temp.append((char)(i + 'a'));

                if(temp.length() > answer.length()) {
                    answer = temp.toString();
                }

                longestWordWithAllPrefixes(root.children[i], temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i=0; i<words.length; i++) {
            buildTrie(words[i]);
        }

        longestWordWithAllPrefixes(root, new StringBuilder(""));
        System.out.println(answer);
    }
}
