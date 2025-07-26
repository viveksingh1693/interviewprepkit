package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleKahnsAlgorithm {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build adjacency list and compute in-degrees
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course); // prerequisite -> course
            inDegree[course]++;
        }

        //add All node with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        int processed = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processed++;
            for (int neighbour : adj.get(current)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        return processed == numCourses;
    }

    public static void main(String[] args) {

    }
}
