import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ivan Minchev on 10/5/2017.
 */

class Tree<T> {
    private T value;
    private List<Tree<T>> children;

    public Tree(T value, Tree<T>... children) {
        this.value = value;
        this.children = new ArrayList<>();
        for (Tree<T> child : children) {
            this.children.add(child);
        }
    }

    public T getValue() {
        return value;
    }

    public List<Tree<T>> getChildren() {
        return Collections.unmodifiableList(this.children);
    }

    public String print(int indent, StringBuilder stringBuilder) {
        stringBuilder.append(String.join("",Collections.nCopies(2 * indent, " ")));
        stringBuilder.append(this.getValue());
        stringBuilder.append("\n");
        for (Tree<T> child : this.getChildren()) {
            child.print(indent + 1, stringBuilder);
        }


        return stringBuilder.toString();
    }

    public Iterable<T> orderDFS() {
        List<T> orderedDFS = new ArrayList<>();
        DFS(this, orderedDFS);
        return orderedDFS;
    }

    private void DFS(Tree<T> tree, List<T> orderedDFS) {
        for (Tree<T> child : tree.getChildren()) {
            DFS(child, orderedDFS);
        }
        orderedDFS.add(tree.getValue());
    }
}
public class Demo {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(7,
                new Tree<>(19,
                        new Tree<>(1),
                        new Tree<>(12),
                        new Tree<>(31)),
                new Tree<>(21),
                new Tree<>(14,
                        new Tree<>(23),
                        new Tree<>(6)));

        String output = tree.print(0, new StringBuilder());
        System.out.println(output);

        Iterable<Integer> elements = tree.orderDFS();
        System.out.println(elements);
    }
}
