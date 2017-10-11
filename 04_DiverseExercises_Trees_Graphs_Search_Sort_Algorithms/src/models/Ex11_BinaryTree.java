package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Ivan Minchev on 10/5/2017.
 */
public class Ex11_BinaryTree<T> {
    private T value;
    private Ex11_BinaryTree<T> leftChild;
    private Ex11_BinaryTree<T> rightChild;

    public Ex11_BinaryTree(T value) {
        this.value = value;
    }

    public Ex11_BinaryTree(T value, Ex11_BinaryTree<T> child) {
        this(value);
        this.leftChild = child;
    }

    public Ex11_BinaryTree(T value, Ex11_BinaryTree<T> leftChild, Ex11_BinaryTree<T> rightCHild) {
        this(value, leftChild);
        this.rightChild = rightCHild;
    }

    private T getValue() {
        return this.value;
    }

    public Ex11_BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public Ex11_BinaryTree<T> getRightChild() {
        return rightChild;
    }

    public void eachInOrder(Consumer<T> consumer) {
        if (this.getLeftChild() != null) {
            this.getLeftChild().eachInOrder(consumer);
        }

        consumer.accept(this.getValue());

        if (this.getRightChild() != null) {
            this.getRightChild().eachInOrder(consumer);
        }

    }

    public void eachPostOrder(Consumer<T> consumer) {
        if (this.getLeftChild() != null) {
            this.getLeftChild().eachPostOrder(consumer);
        }
        if (this.getRightChild() != null) {
            this.getRightChild().eachPostOrder(consumer);
        }
        consumer.accept(this.getValue());
    }

    public String printIndentedPreOrder(int indent, StringBuilder stringBuilder) {
        stringBuilder.append(String.join("", Collections.nCopies(2 * indent, " ")));
        stringBuilder.append(this.getValue());
        stringBuilder.append("\n");
        if (this.getLeftChild() != null) {
            this.getLeftChild().printIndentedPreOrder(indent + 1, stringBuilder);
        }
        if (this.getRightChild() != null) {
            this.getRightChild().printIndentedPreOrder(indent + 1, stringBuilder);
        }


        return stringBuilder.toString();
    }

    public static void main(String[] args) {
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


        String output = binaryTree.printIndentedPreOrder(0, new StringBuilder());
        System.out.println(output);

        // Check eachPostOrder - must be [3, 2, +, 9, 6, *, -, 8, *]
        List<String> nodesEachPostOrder = new ArrayList<>();
        binaryTree.eachPostOrder(nodesEachPostOrder::add);
        System.out.println(nodesEachPostOrder);

        // Check eachInOrder - must be [3, +, 2, -, 9, *, 6, *, 8]
        List<String> nodesEachInOrder = new ArrayList<>();
        binaryTree.eachInOrder(nodesEachInOrder::add);
        System.out.println(nodesEachInOrder);
    }
}
