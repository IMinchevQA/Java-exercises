package tests;

import graphs_SoftUni_Lecture_21Apr2016.Ex02_Graph_DFS;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by Ivan Minchev on 10/3/2017.
 */
public class Tests_Graph_DFS {
    @Test
    public void TestGraphConnectedComponents9Vertices()
    {
        // Arrange
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(new ArrayList<>(Arrays.asList(3, 6)));
        graph.add(new ArrayList<>(Arrays.asList(3, 4, 5, 6)));
        graph.add(new ArrayList<>(Arrays.asList(8)));
        graph.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        graph.add(new ArrayList<>(Arrays.asList(1, 6)));
        graph.add(new ArrayList<>(Arrays.asList(1, 3)));
        graph.add(new ArrayList<>(Arrays.asList(0, 1, 4)));
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>(Arrays.asList(2)));


        // Act
        List<Deque<Integer>> expected = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(6, 4, 5, 1, 3, 0));
        expected.add(deque);
        deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(8, 2));
        expected.add(deque);
        deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(7));
        expected.add(deque);

        List<Deque<Integer>> connectedComponents = Main.getConnectedComponents(graph);

        // Assert
        for (int i = 0; i < connectedComponents.size(); i++) {
            Deque<Integer> expect = expected.get(i);
            Deque<Integer> result = connectedComponents.get(i);

            Set<Integer> e = new TreeSet<>();
            Set<Integer> r = new TreeSet<>();
            e.addAll(expect);
            r.addAll(result);

            Assert.assertEquals(e.toString(), r.toString());
        }
    }

    @Test
    public void TestGraphConnectedComponents1Vertex()
    {
        // Arrange
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(new ArrayList<>());


        // Act
        List<Deque<Integer>> expected = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(0));
        expected.add(deque);

        List<Deque<Integer>> connectedComponents = Main.getConnectedComponents(graph);

        // Assert
        for (int i = 0; i < connectedComponents.size(); i++) {
            Deque<Integer> expect = expected.get(i);
            Deque<Integer> result = connectedComponents.get(i);

            Set<Integer> e = new TreeSet<>();
            Set<Integer> r = new TreeSet<>();
            e.addAll(expect);
            r.addAll(result);

            Assert.assertEquals(e.toString(), r.toString());
        }
    }

    @Test
    public void TestGraphConnectedComponents0Vertices() {
        // Arrange
        List<List<Integer>> graph = new ArrayList<>();

        // Act
        List<Deque<Integer>> expected = new ArrayList<>();

        List<Deque<Integer>> connectedComponents = Main.getConnectedComponents(graph);

        // Assert
        for (int i = 0; i < connectedComponents.size(); i++) {
            Deque<Integer> expect = expected.get(i);
            Deque<Integer> result = connectedComponents.get(i);

            Set<Integer> e = new TreeSet<>();
            Set<Integer> r = new TreeSet<>();
            e.addAll(expect);
            r.addAll(result);

            Assert.assertEquals(e.toString(), r.toString());
        }
    }

    @Test
    public void TestGraphConnectedComponents7Vertices()
    {
        // Arrange
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>(Arrays.asList(2, 6)));
        graph.add(new ArrayList<>(Arrays.asList(1)));
        graph.add(new ArrayList<>(Arrays.asList(4)));
        graph.add(new ArrayList<>(Arrays.asList(3)));
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>(Arrays.asList(1)));


        // Act
        List<Deque<Integer>> expected = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(0));
        expected.add(deque);
        deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(2, 6, 1));
        expected.add(deque);
        deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(4, 3));
        expected.add(deque);
        deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(5));
        expected.add(deque);

        List<Deque<Integer>> connectedComponents = Main.getConnectedComponents(graph);

        // Assert
        for (int i = 0; i < connectedComponents.size(); i++) {
            Deque<Integer> expect = expected.get(i);
            Deque<Integer> result = connectedComponents.get(i);

            Set<Integer> e = new TreeSet<>();
            Set<Integer> r = new TreeSet<>();
            e.addAll(expect);
            r.addAll(result);

            Assert.assertEquals(e.toString(), r.toString());
        }
    }

    @Test
    public void TestGraphConnectedComponents4Vertices()
    {
        // Arrange
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        graph.add(new ArrayList<>(Arrays.asList(0, 1, 2, 3)));
        graph.add(new ArrayList<>(Arrays.asList(0, 1, 3)));
        graph.add(new ArrayList<>(Arrays.asList(1, 2)));


        // Act
        List<Deque<Integer>> expected = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(3, 2, 1, 0));
        expected.add(deque);

        List<Deque<Integer>> connectedComponents = Main.getConnectedComponents(graph);

        // Assert
        for (int i = 0; i < connectedComponents.size(); i++) {
            Deque<Integer> expect = expected.get(i);
            Deque<Integer> result = connectedComponents.get(i);

            Set<Integer> e = new TreeSet<>();
            Set<Integer> r = new TreeSet<>();
            e.addAll(expect);
            r.addAll(result);

            Assert.assertEquals(e.toString(), r.toString());
        }
    }
}

class Main {
    public static void main(String[] args) {
        List<List<Integer>> graph = readGraph();

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.println(connectedComponent);
        }
    }

    private static List<List<Integer>> readGraph() {
        Scanner in = new Scanner(System.in);

        List<List<Integer>> graph = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            List<Integer> connectedComponents = new ArrayList<>();

            String line = in.nextLine();
            if (line.equals("")) {
                graph.add(connectedComponents);
                continue;
            }
            String[] nodes = line.split(" ");

            for (String node : nodes) {
                connectedComponents.add(Integer.parseInt(node));
            }

            graph.add(connectedComponents);
        }
        return graph;
    }

    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited, Deque<Integer> components) {
        if (!visited[node]) {
            visited[node] = true;
            for (int child : graph.get(node)) {
                dfs(graph, child, visited, components);
            }
            components.offer(node);
        }
    }

    static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> connectedComponents = new ArrayList<>();
        for (int node = 0; node < graph.size(); node++) {
            Deque<Integer> components = new ArrayDeque<>();
            dfs(graph, node, visited, components);
            if (components.size() > 0) {
                connectedComponents.add(components);

            }
        }
        return connectedComponents;
    }
}




