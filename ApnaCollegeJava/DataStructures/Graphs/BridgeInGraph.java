package DataStructures.Graphs;

import java.util.ArrayList;

public class BridgeInGraph {
    public static class Edge {
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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    static int time = 0;

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] visited, int[] dt, int[] low, int par) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(e.destination == par) {
                continue;
            } else if(!visited[e.destination]) {
                dfs(graph, e.destination, visited, dt, low, curr);
                low[curr] = Math.min(low[curr], low[e.destination]);
                if(dt[curr] < low[e.destination]) { // bridge
                    System.out.println("Bridge is : " + curr + " --- " + e.destination);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.destination]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge> graph[]) {
        int[] dt = new int[graph.length];
        int low[] = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!visited[i]) {
                dfs(graph, i, visited, dt, low, -1);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getBridge(graph);
    }
}