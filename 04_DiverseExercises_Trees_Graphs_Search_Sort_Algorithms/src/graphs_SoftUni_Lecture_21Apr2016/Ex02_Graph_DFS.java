package graphs_SoftUni_Lecture_21Apr2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Ivan Minchev on 10/3/2017.
 */
public class Ex02_Graph_DFS {
    // Depth-First Search
    private static List<Integer>[] graph;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        graph = new ArrayList[n];

        readGraph(sc, n);
        sc.close();
        findGraphConnectedComponents();

    }

    public static void findGraphConnectedComponents() {
        visited = new boolean[graph.length];
        for (int node = 0; node < graph.length; node++) {
            if(!visited[node]) {
                System.out.printf("Connected component:");
                dfs(node);
                System.out.println();
            }
        }
    }

    private static void dfs(int node) {
        if(!visited[node]) {
            visited[node] = true;
            for (int child : graph[node]) {
                dfs(child);
            }
            System.out.printf(" %1$s", node);
        }
    }

    private static void readGraph(Scanner sc, int n) {
        for (int node = 0; node < n; node++) {
            String line = sc.nextLine();
            if (!line.equals("")) {
                List<Integer> childNodes = Arrays.stream(line.split("\\s+"))
                        .map(s -> s.trim())
                        .mapToInt(s -> Integer.parseInt(s))
                        .boxed()
                        .collect(Collectors.toList());
                graph[node] = childNodes;
            } else {
                graph[node] = new ArrayList<>();
            }
        }
    }
}

/* Input 1:
9
3 6
3 4 5 6
8
0 1 5
1 6
1 3
0 1 4

2

Output 1:
Connected component: 6 4 5 1 3 0
Connected component: 8 2
Connected component: 7


Input 2:
1
0

Output 2:
Connected component: 0


Input 3:
7

2 6
1
4
3

1

Output 3:
Connected component: 0
Connected component: 2 6 1
Connected component: 4 3
Connected component: 5
Connected component: 7


Input 4:
4
1 2 3
0 1 2 3 3
0 1 3
0 1 1 2


Output 4:
Connected component: 3 2 1 0



*/

