package graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class EagerDijkstra {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int dist;

        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static int[] dijkstra(int V, List<List<Pair>> adj, int source) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if(visited[u]) continue;

            visited[u] = true;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.weight;

                if(!visited[v] && dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

    }

}
