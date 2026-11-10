/* Qs - Course Schedule (Facebook/Coinbase/Intuit)

There are a total of numCourses courses you have to take, labeled from 0 to
numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take
course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you
should also have finished course 1. So it is impossible.

Practice online : https://leetcode.com/problems/course-schedule/
*/

package DataStructures.Graphs;

import java.util.Scanner;

public class CourseSchedule {

    public static boolean hasCycle(int[][] prerequisites, int curr, boolean[] visited, boolean[] stack) {
        visited[curr] = true;
        stack[curr] = true;

        for(int i=0; i<prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];

            if(u == curr) {
                if(!visited[v] && hasCycle(prerequisites, v, visited, stack)) {
                    return true;
                } else if(stack[v]) {
                    return true;
                }
            }
        }

        stack[curr] = false;
        return false;
    }

    public static boolean courseSchedule(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!visited[i] && hasCycle(prerequisites, i, visited, stack)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of courses : ");
        int numCourses = sc.nextInt();

        int[][] prerequisites = new int[numCourses][2];

        for(int i=0; i<numCourses; i++) {
            for(int j=0; j<2; j++) {
                prerequisites[i][j] = sc.nextInt();
            }
        }

        System.err.println(courseSchedule(numCourses, prerequisites));

        sc.close();
    }
}