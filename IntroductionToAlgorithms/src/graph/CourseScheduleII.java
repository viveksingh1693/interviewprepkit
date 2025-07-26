package graph;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //Build adj List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int preRequisite = pre[1];
            adj.get(preRequisite).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] topOrder = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            topOrder[index++] = current;
            for (int neighbour : adj.get(current)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        if (index != numCourses) {
            return new int[]{};
        }
        return topOrder;
    }


    public static void main(String[] args) {

    }
}
