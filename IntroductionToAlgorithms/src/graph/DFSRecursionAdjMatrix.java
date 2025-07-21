package graph;

public class DFSRecursionAdjMatrix {
    private final int vertices;
    private final int[][] adjMatrix;

    public DFSRecursionAdjMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];

    }

    private void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }

    }

    public void dfs(int src) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(src, visited);
    }


    public static void main(String[] args) {
        DFSRecursionAdjMatrix graph = new DFSRecursionAdjMatrix(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.dfs(0);
    }


}
