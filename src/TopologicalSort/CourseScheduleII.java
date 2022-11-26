package TopologicalSort;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses]; // 这里默认 courseNo 与 indegree 的index 一一对应
        int[] topologicalOrder = new int[numCourses];
        // Key point: 建图 Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int courseNo = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(pre, new ArrayList<>());
            lst.add(courseNo);
            // 顺序不要搞反了。题目给出的是[courseNo, prerequisite]
            // 所以是 pre (w lower indegree) 指向 courseNo
            adjList.put(pre, lst);
            // Record in-degree of each vertex
            indegree[courseNo] += 1;
        }
        // Add all vertices with 0 in-degree to the queue (course without prerequisite)
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int index = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
            int courseDone = q.poll(); // 从 q 里取出 indegree = 0 的 node 放入 result 中
            topologicalOrder[index++] = courseDone;
            // Reduce the in-degree of each neighbor by 1
            if (adjList.containsKey(courseDone)) {
                // 遍历该课程 (node) 指向的所有课程并将其 indegree - 1, 因为 node 已经修完放入 result
                List<Integer> nextLevelCourses = adjList.get(courseDone);
                for (Integer nextCourse : nextLevelCourses) {
                    indegree[nextCourse]--;
                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (indegree[nextCourse] == 0) {
                        q.offer(nextCourse);
                    }
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (index == numCourses) {
            return topologicalOrder;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleII sol = new CourseScheduleII();
        int[][] prereq = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(sol.findOrder(4, prereq)));
    }
}
