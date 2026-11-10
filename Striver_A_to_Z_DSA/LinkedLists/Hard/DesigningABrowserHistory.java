/*
You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

-> BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
-> void visit(string url) Visits url from the current page. It clears up all the forward history.
-> string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
-> string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

*/

package Striver_A_to_Z_DSA.LinkedLists.Hard;

class BrowserHistory {

    private static class Node {
        String url;
        Node next;
        Node prev;

        Node(String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }

    Node current;

    // Time Complexity = O(1)
    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    // Time Complexity = O(1)
    public void visit(String url) {
        Node newNode = new Node(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }

    // Time Complexity = O(steps)
    public String back(int steps) {
        while(steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }

        return current.url;
    }

    // Time Complexity = O(steps)
    public String forward(int steps) {
        while(steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }

        return current.url;
    }
}

public class DesigningABrowserHistory {
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("takeyouforward.org");
        bh.visit("google.com");
        bh.visit("instgram.com");
        bh.visit("youtube.com");
        bh.visit("facebook.com");

        System.out.println(bh.back(3));
        System.out.println(bh.forward(2));
        System.out.println(bh.forward(10));
        System.out.println(bh.back(10));
    }
}