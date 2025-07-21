package graph;

import java.lang.reflect.Array;
import java.util.*;

public class Dijkstra {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "[" + node + "," + weight + "]";
        }
    }

    public static int[] dijkstra(int V, List<List<Pair>> adj, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(a -> a.weight));

        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            printPriorityQueue(pq);
            printArray(dist);
            Pair current = pq.poll();
            int u = current.node;
            int currentDist = current.weight;

            if (currentDist > dist[u]) {
                continue;
            }

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }

    private static void printPriorityQueue(PriorityQueue<Pair> pq) {
        System.out.println(pq);
    }

    private static void printArray(int[] dist) {
        System.out.println();
        for (int i : dist) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph:
        // 0 -> 1 (weight 2)
        // 0 -> 2 (weight 4)
        // 1 -> 2 (weight 1)
        // 1 -> 3 (weight 7)
        // 2 -> 4 (weight 3)
        // 3 -> 4 (weight 1)

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(3, 7));
        adj.get(2).add(new Pair(4, 3));
        adj.get(3).add(new Pair(4, 1));

        int[] distances = dijkstra(V, adj, 0);

        System.out.println("============================");
        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " : " + distances[i]);
        }
    }
}
