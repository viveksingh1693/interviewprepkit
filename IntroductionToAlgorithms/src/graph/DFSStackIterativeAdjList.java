package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSStackIterativeAdjList {
    private final int vertices;
    private final List<List<Integer>> adjList;

    public DFSStackIterativeAdjList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // Undirected
    }


    public void dfs(int start) {
        boolean visited[] = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
                for (int neighbour : adjList.get(current)) {
                    if (!visited[neighbour]) {
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        DFSStackIterativeAdjList graph = new DFSStackIterativeAdjList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.dfs(0);
    }
}
