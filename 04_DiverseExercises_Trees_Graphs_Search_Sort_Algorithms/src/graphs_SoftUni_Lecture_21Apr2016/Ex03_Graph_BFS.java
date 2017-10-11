package graphs_SoftUni_Lecture_21Apr2016;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Ivan Minchev on 10/3/2017.
 */
public class Ex03_Graph_BFS {
    // Breadth-First Search
    static boolean[] visited;
    static String[] nodeNames = {"Ruse", "Sofia", "Pleven", "Varna", "Bourgas", "Stara Zagora", "Plovdiv"};
    @SuppressWarnings("unchecked")
    static List<Integer>[] childNodes = new ArrayList[]{
        new ArrayList<Integer>(Arrays.asList(3, 6)), // children of node 0 (Ruse)
        new ArrayList<Integer> (Arrays.asList(2, 3, 4, 5, 6)), // children of node 1 (Sofia)
        new ArrayList<Integer> (Arrays.asList(1, 4, 5)), // children of node 2 (Pleven)
        new ArrayList<Integer> (Arrays.asList(0, 1, 5)), // children of node 3 (Varna)
        new ArrayList<Integer> (Arrays.asList(1, 2, 6)), // children of node 4 (Bourgas)
        new ArrayList<Integer> (Arrays.asList(1, 2, 3)), // children of node 5 (Stara Zagora)
        new ArrayList<Integer> (Arrays.asList(0, 1, 4)) // children of node 6 (Plovdiv)
    };

    public static void main(String[] args) {
        traverseBFS(0);
    }

    public static void traverseBFS(int node) {
        Deque<Integer> nodes = new ArrayDeque<>();
        visited = new boolean[childNodes.length];

        visited[node] = true;
        nodes.offer(node);
        while (nodes.size() != 0) {
            int currentNode = nodes.poll();
            System.out.printf("%1$s (%2$s) %3$s", currentNode, nodeNames[currentNode], System.lineSeparator());


            for (int child : childNodes[currentNode]) {
                if (!visited[child]) {
                    visited[child] = true;
                    nodes.offer(child);
                }
            }
        }
    }
}


/*

Output 1:
4 (Bourgas)
1 (Sofia)
2 (Pleven)
6 (Plovdiv)
3 (Varna)
5 (Stara Zagora)
0 (Ruse)
*/
