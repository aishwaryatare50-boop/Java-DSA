package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {
    static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topologicalSort(ArrayList<Edge> graph[], int src, boolean[] visited, Stack<Integer> s) {
        visited[src] = true;

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!visited[e.destination]) {
                topologicalSort(graph, e.destination, visited, s);
            }
        }

        s.push(src);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]) {
                dfs(graph, e.destination, visited);
            }
        }
    }

    // Time Complexity = O(V + E)
    public static void kosarajusAlgorithm(ArrayList<Edge> graph[]) {
        // Step - 1 - O(V + E)
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                topologicalSort(graph, i, visited, s);
            }
        }

        // Step - 2 - O(V + E)
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[graph.length];
        for(int i=0; i<graph.length; i++) {
            visited[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j); // e.src(i) -> e.dest
                transpose[e.destination].add(new Edge(e.destination, e.source));
            }
        }

        // Step - 3 - O(V + E)
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!visited[curr]) {
                dfs(transpose, curr, visited);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosarajusAlgorithm(graph);
    }
}