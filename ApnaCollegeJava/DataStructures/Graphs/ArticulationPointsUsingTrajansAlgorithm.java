package DataStructures.Graphs;

import java.util.ArrayList;

public class ArticulationPointsUsingTrajansAlgorithm {

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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static int time = 0;

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int[] dt, int[] low, boolean[] visited, boolean[] articulationPoints) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbor = e.destination;

            if(par == neighbor) {
                continue;
            } else if(visited[neighbor]) {
                low[curr] = Math.min(low[curr], dt[neighbor]);
            } else {
                dfs(graph, neighbor, curr, dt, low, visited, articulationPoints);
                low[curr] = Math.min(low[curr], low[neighbor]);
                if(dt[curr] <= low[neighbor] && par != -1) {
                    articulationPoints[curr] = true;
                }
                children++;
            }
        }

        if(par == -1 && children > 1) {
            articulationPoints[curr] = true;
        }
    }

    // Time Complexity = O(V + E)
    public static void getArticulationPoints(ArrayList<Edge> graph[]) {
        int V = graph.length;
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] articulationPoints = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                dfs(graph, i, -1, dt, low, visited, articulationPoints);
            }
        }

        for(int i=0; i<V; i++) {
            if(articulationPoints[i]) {
                System.out.println("Articulation Point = " + i);
            }
        }

    }
    public static void main(String[] args) {
        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        getArticulationPoints(graph);
    }
}