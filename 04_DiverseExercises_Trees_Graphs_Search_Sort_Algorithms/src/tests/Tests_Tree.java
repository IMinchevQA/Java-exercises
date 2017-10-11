package tests;

import org.junit.Assert;
import org.junit.Test;

import models.Ex10_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Minchev on 10/4/2017.
 */
public class Tests_Tree {

    @Test
    public void buildTree_forEachTraversal_shouldWorkCorrectly() {
        // Arrange
        Ex10_Tree<Integer> tree =
                new Ex10_Tree<>(7,
                        new Ex10_Tree<>(19,
                                new Ex10_Tree<>(1),
                                new Ex10_Tree<>(12),
                                new Ex10_Tree<>(31)),
                        new Ex10_Tree<>(21),
                        new Ex10_Tree<>(14,
                                new Ex10_Tree<>(23),
                                new Ex10_Tree<>(6)));
        // Act
        List<Integer> nodes = new ArrayList<>();
        tree.each(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { 7, 19, 1, 12, 31, 21, 14, 23, 6 };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void buildTree_printTree_shouldWorkCorrectly() {
        // Arrange
        Ex10_Tree<Integer> tree =
                new Ex10_Tree<>(7,
                        new Ex10_Tree<>(19,
                                new Ex10_Tree<>(1),
                                new Ex10_Tree<>(12),
                                new Ex10_Tree<>(31)),
                        new Ex10_Tree<>(21),
                        new Ex10_Tree<>(14,
                                new Ex10_Tree<>(23),
                                new Ex10_Tree<>(6)));

        // Act
        String output = tree.print(0, new StringBuilder());

        // Assert
        String expectedOutput = "7\n  19\n    1\n    12\n    31\n  21\n  14\n    23\n    6\n";
        Assert.assertEquals(expectedOutput, output);
    }

    @Test
    public void orderDFS_singleElement_shouldWordCorrectly() {
        // Arrange
        Ex10_Tree<Integer> tree = new Ex10_Tree<>(7);

        // Act
        List<Integer> resultElements = new ArrayList<>();
        Iterable<Integer> elements = tree.orderDFS();
        elements.forEach(resultElements::add);
        int[] actualResult = new int[resultElements.size()];
        for (int i = 0; i < resultElements.size(); i++) {
            actualResult[i] = resultElements.get(i);
        }

        // Assert
        int[] expectedOutput = new int[] { 7 };
        Assert.assertArrayEquals(expectedOutput, actualResult);
    }

    @Test
    public void orderDFS_multipleElements_shouldWordCorrectly() {
        // Arrange
        Ex10_Tree<Integer> tree =
                new Ex10_Tree<>(7,
                        new Ex10_Tree<>(19,
                                new Ex10_Tree<>(1),
                                new Ex10_Tree<>(12),
                                new Ex10_Tree<>(31)),
                        new Ex10_Tree<>(21),
                        new Ex10_Tree<>(14,
                                new Ex10_Tree<>(23),
                                new Ex10_Tree<>(6)));

        // Act
        List<Integer> resultElements = new ArrayList<>();
        Iterable<Integer> elements = tree.orderDFS();
        elements.forEach(resultElements::add);
        int[] actualResult = new int[resultElements.size()];
        for (int i = 0; i < resultElements.size(); i++) {
            actualResult[i] = resultElements.get(i);
        }

        // Assert
        int[] expectedOutput = new int[] { 1, 12, 31, 19, 21, 23, 6, 14, 7 };
        Assert.assertArrayEquals(expectedOutput, actualResult);
    }

    @Test
    public void orderBFS_singleElement_shouldWorkCorrectly() {
        // Arrange
        Ex10_Tree<Integer> tree =
                new Ex10_Tree<>(7);

        // Act
        List<Integer> resultElements = new ArrayList<>();
        Iterable<Integer> elements = tree.orderBFS();
        elements.forEach(resultElements::add);
        int[] actualResult = new int[resultElements.size()];
        for (int i = 0; i < resultElements.size(); i++) {
            actualResult[i] = resultElements.get(i);
        }

        // Assert
        int[] expectedOutput = new int[] { 7 };
        Assert.assertArrayEquals(expectedOutput, actualResult);
    }

    @Test
    public void orderBFS_multipleElements_shouldWorkCorrectly() {
        // Arrange
        Ex10_Tree<Integer> tree =
                new Ex10_Tree<>(7,
                        new Ex10_Tree<>(19,
                                new Ex10_Tree<>(1),
                                new Ex10_Tree<>(12),
                                new Ex10_Tree<>(31)),
                        new Ex10_Tree<>(21),
                        new Ex10_Tree<>(14,
                                new Ex10_Tree<>(23),
                                new Ex10_Tree<>(6)));

        // Act
        List<Integer> resultElements = new ArrayList<>();
        Iterable<Integer> elements = tree.orderBFS();
        elements.forEach(resultElements::add);
        int[] actualResult = new int[resultElements.size()];
        for (int i = 0; i < resultElements.size(); i++) {
            actualResult[i] = resultElements.get(i);
        }

        // Assert
        int[] expectedOutput = new int[] { 7, 19, 21, 14, 1, 12, 31, 23, 6 };
        Assert.assertArrayEquals(expectedOutput, actualResult);
    }
}
