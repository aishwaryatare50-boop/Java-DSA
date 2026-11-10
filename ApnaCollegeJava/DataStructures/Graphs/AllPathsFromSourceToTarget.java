package DataStructures.Graphs;

import java.util.ArrayList;

public class AllPathsFromSourceToTarget {

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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void printAllPaths(ArrayList<Edge> graph[], boolean[] visited, int curr, int target, StringBuilder path) {

        // O(V^V)
        if(curr == target) {
            System.out.println(path);
            return;
        }

        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.destination]) {
                printAllPaths(graph, visited, e.destination, target, path.append(e.destination));
                path.deleteCharAt(path.length()-1);
            }
        }

        visited[curr] = false;
    }
    public static void main(String[] args) {
        int V = 7;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        boolean[] visited = new boolean[V];

        printAllPaths(graph, visited, 0, 5, new StringBuilder("0"));
        
    }
}
