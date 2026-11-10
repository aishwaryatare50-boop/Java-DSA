package DataStructures.Graphs;

import java.util.ArrayList;

public class CycleDetectionInUndirectedGraphs {

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
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    // Time complexity = O(V + E)
    public static boolean hasCycleUndirected(ArrayList<Edge> graph[], boolean[] visited, int curr, int par) {
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(visited[e.destination] && e.destination != par) {
                return true;
            } else if(!visited[e.destination] && hasCycleUndirected(graph, visited, e.destination, curr)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                boolean hasCycle = hasCycleUndirected(graph, visited, i, -1);

                if(hasCycle) {
                    System.out.println(hasCycle);
                    break;
                }
            }
        }
    }
}