package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithmGeneric {

    public static List<Integer> kahnsTopologicalSort(int numVertices, List<List<Integer>> adj) {
        int[] inDegrees = new int[numVertices];

        //compute indegrees of all vertices
        for (int u = 0; u < numVertices; u++) {
            for (int v : adj.get(u)) {
                inDegrees[v]++;
            }
        }

        //Initialize queue with vertices having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            if (inDegrees[i] == 0)
                queue.offer(i);
        }
        List<Integer> topOrder = new ArrayList<>();
        int processed = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topOrder.add(u);
            processed++;

            for (int v : adj.get(u)) {
                inDegrees[v]--;
                if (inDegrees[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (processed != numVertices) {
            System.out.println("Cycle detected: Topological sort not possible");
            return new ArrayList<>();
        }

        return topOrder;
    }
}
