import java.util.Scanner;

public class Ex02_LinkedList_RemoveOdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedListNode res;

        int _list_size =  Integer.parseInt(in.nextLine());
        int _list_i;
        int _list_item;
        LinkedListNode _list = null;
        LinkedListNode _list_tail = null;

        for(_list_i = 0; _list_i < _list_size; _list_i++) {
            _list_item = Integer.parseInt(in.nextLine().trim());
            if(_list_i == 0) {
                _list = _insert_node_into_singlylinkedlist(_list, _list_tail, _list_item);
                _list_tail = _list;
            }
            else {
                _list_tail = _insert_node_into_singlylinkedlist(_list, _list_tail, _list_item);
            }
        }

        res = deleteOdd(_list);
        while (res != null) {
//            bw.write(String.valueOf(res.val));
//            bw.newLine();
            System.out.print(String.valueOf(res.val));
            System.out.println();
            res = res.next;
        }
        in.close();

    }

    static LinkedListNode deleteOdd(LinkedListNode list) {
        LinkedListNode currentNode = list;
        while (currentNode != null && currentNode.val % 2 != 0) {
            currentNode = currentNode.next;
            list = currentNode;
        }

        if (currentNode == null) {
            return null;
        }

        LinkedListNode last_even = currentNode;
        currentNode = currentNode.next;

        while (currentNode != null) {
            if (currentNode.val % 2 == 0) {
                last_even.next = currentNode; // These changes affect the "list" also!!!
                last_even = currentNode;
            }
            currentNode = currentNode.next;
        }
        last_even.next = null;
        return list;
    }

    public static class LinkedListNode {
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    }

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val) {
        if (head == null) {
            head = new LinkedListNode(val);
            tail = head;
        } else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }
}





/*
Input 1:
8
7
2
1
3
4
5
6
9

Output 1:
2
4
6
*/