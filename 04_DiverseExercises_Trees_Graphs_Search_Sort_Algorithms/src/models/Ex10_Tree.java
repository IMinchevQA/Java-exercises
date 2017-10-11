package models;

import java.sql.Connection;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Ivan Minchev on 10/4/2017.
 */
public class Ex10_Tree<T> {
    private T value;
    private List<Ex10_Tree<T>> children;

    public Ex10_Tree (T value, Ex10_Tree<T>... children) {
        this.value = value;
        this.children = new ArrayList<>();
        for (Ex10_Tree<T> child : children) {
            this.children.add(child);
        }
    }

    private T getValue() {
        return this.value;
    }

    private List<Ex10_Tree<T>> getChildren() {
        return Collections.unmodifiableList(this.children);
    }


    public void each(Consumer<T> consumer) {
        consumer.accept(this.getValue());
        for (Ex10_Tree<T> child: this.getChildren()) {
            child.each(consumer);
        }
    }


    public Iterable<T> orderDFS() {
        List<T> result = new ArrayList<>();
        DFS(this, result);
        return result;
    }

    private void DFS(Ex10_Tree<T> tree, List<T> result) {
        for (Ex10_Tree<T> child : tree.getChildren()) {
            DFS(child, result);
        }
        result.add(tree.getValue());
    }

    public Iterable<T> orderBFS() {
        List<T> result = new ArrayList<>();
        Deque<Ex10_Tree<T>> queue = new ArrayDeque<>();
        queue.offer(this);
        while (queue.size() > 0) {
            Ex10_Tree<T> node = queue.poll();
            result.add(node.getValue());
            for (Ex10_Tree<T> child : node.getChildren()) {
                queue.offer(child);
            }
        }
        return result;
    }

    public String print(int indent, StringBuilder stringBuilder) {
        stringBuilder.append(String.join("", Collections.nCopies(2 * indent, " ")));
        stringBuilder.append(this.getValue());
        stringBuilder.append("\n");
        for (Ex10_Tree<T> child : this.getChildren()) {
            child.print(indent + 1, stringBuilder);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
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

        List<Integer> nodes = new ArrayList<>();
        tree.each(nodes::add);
        System.out.println(nodes);

        // Check the print method
        String output = tree.print(0, new StringBuilder());
        System.out.println(output);


        // Check orderDFS method
        List<Integer> resultElementsDFS = new ArrayList<>();
        Iterable<Integer> elementsDFS = tree.orderDFS();
        elementsDFS.forEach(resultElementsDFS::add);
        System.out.println(resultElementsDFS);

        // Check orderBFS method
        List<Integer> resultElementsBFS = new ArrayList<>();
        Iterable<Integer> elementsBFS = tree.orderBFS();
        elementsBFS.forEach(resultElementsBFS::add);
        System.out.println(resultElementsBFS);
    }

}

