package tests;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by Ivan Minchev on 10/3/2017.
 */
public class Tests_TopologicalSorter {
    @Test
    public void TestTopSortAcyclicGraph6Vertices()
    {
        // Arrange
        Map<String, List<String>> graph = new LinkedHashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("D", "E")));
        graph.put("C", new ArrayList<>(Arrays.asList("F")));
        graph.put("D", new ArrayList<>(Arrays.asList("C", "F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>());

        // Act
        Collection<String> topSorter = Main2.topSort(graph);

        // Assert
        Assert.assertEquals("[A, B, E, D, C, F]", topSorter.toString());
    }

    @Test
    public void TestTopSortAcyclicGraph5Vertices()
    {
        // Arrange
        Map<String, List<String>> graph = new LinkedHashMap<>();
        graph.put("IDEs", new ArrayList<>(Arrays.asList("variables", "loops")));
        graph.put("variables", new ArrayList<>(Arrays.asList("conditionals", "loops", "bits")));
        graph.put("loops", new ArrayList<>(Arrays.asList("bits")));
        graph.put("bits", new ArrayList<>(Arrays.asList()));
        graph.put("conditionals", new ArrayList<>(Arrays.asList("loops")));

        // Act
        Collection<String> topSorter = Main2.topSort(graph);

        // Assert
        Assert.assertEquals("[IDEs, variables, conditionals, loops, bits]", topSorter.toString());
    }

    @Test
    public void TestTopSortGraph1Vertex()
    {
        // Arrange
        Map<String, List<String>> graph = new LinkedHashMap<>();
        graph.put("A", new ArrayList<>());

        // Act
        Collection<String> topSorted = Main2.topSort(graph);

        // Assert
        Assert.assertEquals("[A]", topSorted.toString());
    }

    @Test
    public void TestTopSortEmptyGraph()
    {
        // Arrange
        Map<String, List<String>> graph = new LinkedHashMap<>();


        // Act
        Collection<String> topSorted = Main2.topSort(graph);

        // Assert
        Assert.assertEquals("[]", topSorted.toString());
    }

    @Test
    public void TestTopSortAcyclicGraph8Vertices()
    {
        // Arrange
        Map<String, List<String>> graph = new LinkedHashMap<>();
        graph.put("H", new ArrayList<>(Arrays.asList("G")));
        graph.put("G", new ArrayList<>());
        graph.put("B", new ArrayList<>(Arrays.asList("A")));
        graph.put("A", new ArrayList<>());
        graph.put("F", new ArrayList<>(Arrays.asList("B", "C", "E")));
        graph.put("C", new ArrayList<>(Arrays.asList("A")));
        graph.put("E", new ArrayList<>(Arrays.asList("C", "A")));
        graph.put("D", new ArrayList<>(Arrays.asList("A", "B")));

        // Act
        Collection<String> topSorted = Main2.topSort(graph);

        // Assert
//        Assert.assertEquals("[D, F, E, C, B, A, H, G]", topSorted.toString()); // Wrong test
        Assert.assertEquals("[D, F, B, E, C, A, H, G]", topSorted.toString());
    }

    @Test
    public void TestTopSortAcyclicGraph2Vertices()
    {
        // Arrange
        Map<String, List<String>> graph = new LinkedHashMap<>();
        graph.put("First", new ArrayList<>(Arrays.asList("Second")));
        graph.put("Second", new ArrayList<>());

        // Act
        Collection<String> topSorted = Main2.topSort(graph);

        // Assert
        Assert.assertEquals("[First, Second]", topSorted.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestTopSortGraph2VerticesWithCycle()
    {
        // Arrange
        Map<String, List<String>> graph = new LinkedHashMap<>();
        graph.put("First", new ArrayList<>(Arrays.asList("Second")));
        graph.put("Second", new ArrayList<>(Arrays.asList("First")));

        // Act
        // Assert
        Collection<String> topSorted = Main2.topSort(graph);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestTopSortGraph7VerticesWithCycle()
    {
        // Arrange
        Map<String, List<String>> graph = new LinkedHashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList("B")));
        graph.put("B", new ArrayList<>(Arrays.asList("C")));
        graph.put("C", new ArrayList<>(Arrays.asList("D", "E")));
        graph.put("D", new ArrayList<>(Arrays.asList("E")));
        graph.put("E", new ArrayList<>(Arrays.asList("F", "C")));
        graph.put("F", new ArrayList<>());
        graph.put("Z", new ArrayList<>(Arrays.asList("A")));

        // Act
        // Assert
        Collection<String> topSorted = Main2.topSort(graph);
    }
}

class Main2 {
    private static Map<String, List<String>> graphTopSort;
    public static void main(String[] args) {
        System.out.println("MY NAME IS E-DUBBLE");
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        graphTopSort = graph;
        Map<String, Integer> predecessorsCount = new HashMap<>();

        for (Map.Entry node : graphTopSort.entrySet()) {
            predecessorsCount.putIfAbsent(String.valueOf(node.getKey()), 0);

            for (String childNode : (List<String>) node.getValue()) {
                predecessorsCount.putIfAbsent(childNode, 0);
                predecessorsCount.put(childNode, predecessorsCount.get(childNode) + 1);
            }
        }

        List<String> sortedNodes = new ArrayList<String>();
        while (true) {
            Optional<String> currentNode = predecessorsCount.keySet()
                    .stream()
                    .filter(e -> predecessorsCount.get(e) == 0 && !sortedNodes.contains(e))
                    .findFirst();

            if (!currentNode.isPresent()) {
                break;
            }

            for (String child : graphTopSort.get(currentNode.get())) {
                predecessorsCount.put(child, predecessorsCount.get(child) - 1);
            }
            graphTopSort.remove(currentNode.get());
            sortedNodes.add(currentNode.get());
        }

        if (graphTopSort.size() > 0) {
            throw new IllegalArgumentException("A cycle detected in a graph");
        }

        return sortedNodes;
    }
}

