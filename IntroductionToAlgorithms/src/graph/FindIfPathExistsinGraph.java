package graph;

import java.util.*;

public class FindIfPathExistsinGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(adj, visited, source, destination);

    }

    private boolean dfs(List<List<Integer>> adj, boolean[] visited, int current, int destination) {
        if (current == destination) return true;
        visited[current] = true;
        for (int neighbour : adj.get(current)) {
            if (!visited[neighbour]) {
                if (dfs(adj, visited, neighbour, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}
