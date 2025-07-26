package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CloneGraphDFS {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public  Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private  Node dfs(Node node, HashMap<Node, Node> visited) {

        if (visited.containsKey(node))
            return visited.get(node);

        Node clone = new Node(node.val);
        visited.put(node, clone);

        for (Node neighbour : node.neighbors) {
            clone.neighbors.add(dfs(neighbour, visited));
        }
        return clone;
    }

    public static void main(String[] args) {
        // Create a sample graph:
        // 1 -- 2
        // |    |
        // 4 -- 3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.addAll(Arrays.asList(n2, n4));
        n2.neighbors.addAll(Arrays.asList(n1, n3));
        n3.neighbors.addAll(Arrays.asList(n2, n4));
        n4.neighbors.addAll(Arrays.asList(n1, n3));

        CloneGraphDFS solver = new CloneGraphDFS();
        Node clonedGraph = solver.cloneGraph(n1);

        System.out.println("Graph cloned successfully. Cloned Node Val: " + clonedGraph.val);
    }
}
