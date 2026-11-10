package DataStructures.Graphs.ShortestPathAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    static class Edge {
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

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.distance - p2.distance; // ascending order
            // return p2.distance - this.distance descending order
        }
    } 

    // Time Complexity = O(E + ElogV)
    public static void dijkstrasAlgorithm(ArrayList<Edge> graph[], int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] distance = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] visited = new boolean[graph.length];

        pq.add(new Pair(src, 0));

        // bfs
        while(!pq.isEmpty()) {
            Pair curr = pq.remove(); // shortest
            if(!visited[curr.node]) {
                visited[curr.node] = true;

                for(int i=0; i<graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.source;
                    int v = e.destination;
                    if(distance[u] + e.weight < distance[v]) { // relaxation
                        distance[v] = distance[u] + e.weight;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        for(int i=0; i<graph.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        dijkstrasAlgorithm(graph, 0);
    }
}
