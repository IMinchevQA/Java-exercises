package tests;
import org.junit.Assert;
import org.junit.Test;

import models.Ex04_LinkedList;

/**
 * Created by Ivan Minchev on 9/22/2017.
 */
public class Tests_LinkedList {
    @Test
    public void addFirstShouldIncreaseCount() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        list.addFirst(1);

        Assert.assertEquals(1, list.size());
    }

    @Test
    public void addLastShouldIncreaseCount() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        list.addLast(1);

        Assert.assertEquals(1, list.size());
    }

    @Test
    public void addFirstShouldAddElement() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);

        Integer i = 2;
        for (Integer item : list) {
            Assert.assertEquals(i, item);
            i--;
        }
    }

    @Test
    public void AddLastShouldAddElement() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        list.addLast(1);
        list.addLast(2);

        Integer i = 1;
        for (Integer item : list) {
            Assert.assertEquals(Integer.valueOf(i), item);
            i++;
        }
    }

    @Test
    public void addFirstMultipleElementsShouldAddElement() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addFirst(i);
        }

        int expected = 100;
        Assert.assertEquals(expected, list.size());
    }

    @Test
    public void addLastMultipleElementsShouldAddElement() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        int expected = 100;
        for (Integer item : list) {
            Assert.assertEquals(expected, list.size());
        }
    }

    @Test
    public void removeFirstSingleElementShouldDecreaseCount() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.removeFirst();

        Assert.assertEquals(1, list.size());
    }

    @Test
    public void RemoveLastSingleElementShouldDecreaseCount() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.removeLast();

        Assert.assertEquals(1, list.size());
    }

    @Test
    public void RemoveFirstMultipleElementsShouldRemove() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        for (Integer i = 0; i < 100; i++) {
            Assert.assertEquals(i, list.removeFirst());
        }

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void RemoveLastMultipleElementsShouldRemove() {
        Ex04_LinkedList<Integer> list = new Ex04_LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addFirst(i);
        }

        for (Integer i = 0; i < 100; i++) {
            Assert.assertEquals(i, list.removeLast());
        }

        Assert.assertEquals(0, list.size());
    }

    public static void main(String[] args) {

    }
}
