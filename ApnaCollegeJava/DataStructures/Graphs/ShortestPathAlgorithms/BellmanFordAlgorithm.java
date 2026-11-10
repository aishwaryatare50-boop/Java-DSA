package DataStructures.Graphs.ShortestPathAlgorithms;

import java.util.ArrayList;

public class BellmanFordAlgorithm {

    public static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));
        
        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    // Time Complexity = O(E.V)
    public static void bellmanFordAlgorithm(ArrayList<Edge> graph[], int source) {
        int[] distance = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(i != source) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        for(int k=0; k<graph.length-1; k++) { // O(V)
            //O(E)
            for(int i=0; i<graph.length; i++) {
                for(int j=0; j<graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.source;
                    int v = e.destination;
                    
                    if(distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]) {
                        distance[v] = distance[u] + e.weight;
                    }
                }
            }
        }

        // detect negative weight cycles
        for(int i=0; i<graph.length; i++) {
                for(int j=0; j<graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.source;
                    int v = e.destination;
                    
                    if(distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]) {
                        System.out.println("Negative weight cycle");
                    }
                }
            }

        for(int i=0; i<distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellmanFordAlgorithm(graph, 0);
    }
}
