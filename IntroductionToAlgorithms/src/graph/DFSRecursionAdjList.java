package graph;

import java.util.ArrayList;
import java.util.List;

public class DFSRecursionAdjList {

    private final int vertices;
    private final List<List<Integer>> adjList;

    public DFSRecursionAdjList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }


    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(start, visited);
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int neighbour : adjList.get(vertex)) {
            if (!visited[neighbour]) {
                dfsUtil(neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSRecursionAdjList graph = new DFSRecursionAdjList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.dfs(0);
    }
}
