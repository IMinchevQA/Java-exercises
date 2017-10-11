
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Ivan Minchev on 9/22/2017.
 */
public class Ex03_CreateNode {
    public static void main(String[] args) {
        // Creating a node;
        LinkedListNode<Integer> firstNode = new LinkedListNode<>(5);
        LinkedListNode<Integer> secondNode = new LinkedListNode<>(10);
        LinkedListNode<Integer> thirdNode = new LinkedListNode<>(-15);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(20);



//        firstNode.setNext(secondNode);
//        secondNode.setNext(thirdNode);
//
//        LinkedListNode<Integer> current = firstNode;
//        while (current!= null) {
//            System.out.println(current.val);
//            current = current.getNext();
//        }

        linkedList.removeFirst();
        Iterator<Integer> it = linkedList.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("debug");


    }

    public static class LinkedListNode <T> {
        private T val;
        private LinkedListNode<T> next;

        LinkedListNode(T node_value) {
            val = node_value;
            next = null;
        }

        public T getValue() {
            return this.val;
        }

        public void setValue(T value) {
            this.val = value;
        }

        public LinkedListNode<T> getNext() {
            return this.next;
        }

        public void setNext (LinkedListNode<T> nextNode) {
            this.next = nextNode;
        }
    }
}


