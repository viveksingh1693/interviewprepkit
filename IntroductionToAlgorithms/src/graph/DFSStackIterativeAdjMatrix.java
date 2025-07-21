package graph;

import java.util.Stack;

public class DFSStackIterativeAdjMatrix {
    private final int vertices;
    private final int[][] adjMatrix;

    public DFSStackIterativeAdjMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];

    }

    private void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }


    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
                for (int i = vertices - 1; i >= 0; i--) {
                    if (adjMatrix[current][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        DFSStackIterativeAdjMatrix graph = new DFSStackIterativeAdjMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.dfs(0);

    }


}
