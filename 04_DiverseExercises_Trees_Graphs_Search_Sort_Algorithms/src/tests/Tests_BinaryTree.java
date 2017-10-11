package tests;

import org.junit.Assert;
import org.junit.Test;

import models.Ex11_BinaryTree;

import java.util.*;

/**
 * Created by Ivan Minchev on 10/5/2017.
 */
public class Tests_BinaryTree {
    @Test
    public void buildBinaryTree_forEachTraversal_inOrder_shouldWorkCorrectly() {
        // Arrange
        Ex11_BinaryTree<String> binaryTree =
                new Ex11_BinaryTree<>("*",
                        new Ex11_BinaryTree<>("+",
                                new Ex11_BinaryTree<>("3"),
                                new Ex11_BinaryTree<>("2")),
                        new Ex11_BinaryTree<>("-",
                                new Ex11_BinaryTree<>("9"),
                                new Ex11_BinaryTree<>("6")));

        // Act
        List<String> nodes = new ArrayList<>();
        binaryTree.eachInOrder(nodes::add);
        String[] actualResult = new String[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            actualResult[i] = nodes.get(i);
        }

        // Assert
        String[] expectedNodes = new String[] { "3", "+", "2", "*", "9", "-", "6" };
        Assert.assertArrayEquals(expectedNodes, actualResult);
    }

    @Test
    public void buildBinaryTree_forEachTraversal_postOrder_shouldWorkCorrectly() {
        // Arrange
        Ex11_BinaryTree<String> binaryTree =
                new Ex11_BinaryTree<>("*",
                        new Ex11_BinaryTree<>("+",
                                new Ex11_BinaryTree<>("3"),
                                new Ex11_BinaryTree<>("2")),
                        new Ex11_BinaryTree<>("-",
                                new Ex11_BinaryTree<>("9"),
                                new Ex11_BinaryTree<>("6")));

        // Act
        List<String> nodes = new ArrayList<>();
        binaryTree.eachPostOrder(nodes::add);
        String[] actualResult = new String[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            actualResult[i] = nodes.get(i);
        }

        // Assert
        String[] expectedNodes = new String[] { "3", "2", "+", "9", "6", "-", "*" };
        Assert.assertArrayEquals(expectedNodes, actualResult);
    }

    @Test
    public void buildBinaryTree_printIndentedPreOrder_shouldWorkCorrectly() {
        // Arrange
        Ex11_BinaryTree<String> binaryTree =
                new Ex11_BinaryTree<>("*",
                        new Ex11_BinaryTree<>("-",
                                new Ex11_BinaryTree<>("+",
                                        new Ex11_BinaryTree<>("3"),
                                        new Ex11_BinaryTree<>("2")),
                                new Ex11_BinaryTree<>("*",
                                        new Ex11_BinaryTree<>("9"),
                                        new Ex11_BinaryTree<>("6"))),
                        new Ex11_BinaryTree<>("8"));

        // Act
        String output = binaryTree.printIndentedPreOrder(0, new StringBuilder());
        // Assert
        String expectedOutput = "*\n  -\n    +\n      3\n      2\n    *\n      9\n      6\n  8\n";
        Assert.assertEquals(expectedOutput, output);
    }
}
