package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int parent;
        int node;
        int cost;

        public Pair(int parent, int node, int cost) {
            this.parent = parent;
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return Integer.compare(this.cost, p2.cost);// ascennding
        }
    }

    // Time Complexity = O(ElogE)
    public static void primsAlgorithm(ArrayList<Edge> graph[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // non-mst set
        boolean[] visited = new boolean[graph.length]; // mst set

        pq.add(new Pair(-1, 0, 0));

        int mstCost = 0;
        ArrayList<Edge> mst = new ArrayList<>();

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(!visited[curr.node]) {
                visited[curr.node] = true;
                mstCost += curr.cost;
                if(curr.parent != -1) 
                    mst.add(new Edge(curr.parent, curr.node, curr.cost));

                for(int i=0; i<graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if(!visited[e.destination]) {
                        pq.add(new Pair(curr.node, e.destination, e.weight));
                    }
                }
            }
        }

        System.out.println("Minnimum cost of mst = " +  mstCost);
        for(int i=0; i<mst.size(); i++) {
            System.out.println(mst.get(i).source + " " + mst.get(i).destination + " " + mst.get(i).weight);
        }
    }

    public static void main(String[] args) {
        int V = 4;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        primsAlgorithm(graph);
    }
}