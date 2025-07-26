package graph;

import java.util.*;

public class CloneGraphBFS {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node clone = new Node(node.val);
        visited.put(node, clone);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    Node neighborClone = new Node(neighbor.val);
                    visited.put(neighbor, neighborClone);
                    queue.offer(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }
        return clone;
    }


}
