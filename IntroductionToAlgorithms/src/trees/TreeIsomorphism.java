package trees;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TreeIsomorphism {

    public static class TreeNode {
        private int id;
        private TreeNode parent;
        private List<TreeNode> children;

        public TreeNode(int id) {
            this(id, null);
        }

        public TreeNode(int id, TreeNode parent) {
            this.id = id;
            this.parent = parent;
            children = new LinkedList<>();
        }

        public void addChildren(TreeNode... nodes) {
            children.addAll(Arrays.asList(nodes));
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public void setChildren(List<TreeNode> children) {
            this.children = children;
        }
    }

    private static TreeNode rootTree(List<List<Integer>> graph, int rootId) {
        TreeNode root = new TreeNode(rootId);
        return buildTree(graph, root);
    }

    private static TreeNode buildTree(List<List<Integer>> graph, TreeNode node) {
        for (int neighbor : graph.get(node.id)) {
            if (node.getParent() != null && neighbor == node.getParent().getId()) {
                continue;
            }

            TreeNode child = new TreeNode(neighbor, node);
            node.addChildren(child);
            buildTree(graph, child);
        }
        return node;
    }

    public static String encode(TreeNode node) {
        if (node == null) {
            return "";
        }

        List<String> labels = new LinkedList<>();
        for (TreeNode child : node.getChildren()) {
            labels.add(encode(child));
        }
        Collections.sort(labels);
        StringBuilder sb = new StringBuilder();
        for (String label : labels) {
            sb.append(label);
        }
        return "(" + sb.toString() + ")";
    }
}
