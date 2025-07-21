package graph;

import java.util.Arrays;

public class BellmanFord {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void bellmanFord(Edge[] edges, int V, int E, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        //step 1: Relax edge v - 1 times;
        for (int i = 1; i <= V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].u;
                int v = edges[j].v;
                int w = edges[j].w;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Step 2: Check for negative weight cycles
        for (int j = 0; j < E; j++) {
            int u = edges[j].u;
            int v = edges[j].v;
            int w = edges[j].w;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains a negative weight cycle.");
                return;
            }
        }

        // Print the result
        System.out.println("Vertex distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " : " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int V = 5; // number of vertices
        int E = 8; // number of edges

        Edge[] edges = new Edge[E];

        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        bellmanFord(edges, V, E, 0);
    }
}
