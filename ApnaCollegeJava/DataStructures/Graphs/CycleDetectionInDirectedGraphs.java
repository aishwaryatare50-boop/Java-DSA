package DataStructures.Graphs;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraphs {

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

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    // Time Complexity = O(V+E)
    public static boolean hasCycle(ArrayList<Edge> graph[], boolean[] visited, int curr, boolean[] rec) {
        visited[curr] = true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(rec[e.destination]) {
                return true;
            } else if(!visited[e.destination]) {
                if(hasCycle(graph, visited, e.destination, rec)) {
                    return true;
                }
            }
        }

        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean[] visited = new boolean[V];
        boolean[] rec = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                boolean hasCycle = hasCycle(graph, visited, 0, rec);
                if(hasCycle) {
                    System.out.println(hasCycle);
                    break;
                }
                
            }
        }
        
    }
}
