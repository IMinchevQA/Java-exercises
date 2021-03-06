package tests;

import models.Ex06_DoublyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests_DoublyLinkedList {

    @Test
    public void addFirst_emptyList_shouldAddElement() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        list.addFirst(5);
        int expectedSize = 1;
        Assert.assertEquals(expectedSize, list.size());

        List<Integer> items = new ArrayList<>();
        for (Integer integer : list) {
            items.add(integer);
        }

        int[] expectedArray = new int[]{5};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }


    @Test
    public void addFirst_severalElements_shouldAddElementsCorrectly() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        list.addFirst(10);
        list.addFirst(5);
        list.addFirst(3);

        int expectedSize = 3;
        Assert.assertEquals(expectedSize, list.size());

        List<Integer> items = new ArrayList<>();
        list.forEach(item -> items.add(item));

        int[] expectedArray = new int[]{3, 5, 10};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void addLast_emptyList_shouldAddElement() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        list.addLast(5);
        int expectedSize = 1;
        Assert.assertEquals(expectedSize, list.size());

        List<Integer> items = new ArrayList<>();
        for (Integer integer : list) {
            items.add(integer);
        }

        int[] expectedArray = new int[]{5};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void addLast_severalElements_shouldAddElementsCorrectly() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        list.addLast(5);
        list.addLast(10);
        list.addLast(15);

        int expectedSize = 3;
        Assert.assertEquals(expectedSize, list.size());

        List<Integer> items = new ArrayList<>();
        for (Integer integer : list) {
            items.add(integer);
        }

        int[] expectedArray = new int[]{5, 10, 15};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void removeFirst_oneElement_shouldMakeListEmpty() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        list.addLast(5);

        int element = list.removeFirst();

        int expectedElement = 5;
        int expectedSize = 0;
        Assert.assertEquals(expectedElement, element);
        Assert.assertEquals(expectedSize, list.size());

        List<Integer> items = new ArrayList<>();
        for (Integer item : list) {
            items.add(item);
        }

        int[] expectedArray = new int[]{};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }


    @Test(expected = IllegalArgumentException.class)
    public void removeFirst_emptyList_shouldThrowException() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        int element = list.removeFirst();
    }

    @Test
    public void removeFirst_severalElements_shouldRemoveElementsCorrectly() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        int element = list.removeFirst();

        int expectedElement = 5;
        int expectedSize = 2;
        Assert.assertEquals(expectedElement, element);
        Assert.assertEquals(expectedSize, list.size());

        List<Integer> items = new ArrayList<>();
        for (Integer item : list) {
            items.add(item);
        }

        int[] expectedArray = new int[]{6, 7};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }


    @Test
    public void removeLast_oneElement_shouldMakeListEmpty() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        list.addFirst(5);

        int element = list.removeLast();

        int expectedElement = 5;
        int expectedSize = 0;
        Assert.assertEquals(expectedElement, element);
        Assert.assertEquals(expectedSize, list.size());

        List<Integer> items = new ArrayList<>();
        for (Integer item : list) {
            items.add(item);
        }

        int[] expectedArray = new int[]{};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }


    @Test(expected = IllegalArgumentException.class)
    public void removeLast_emptyList_shouldThrowException() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        int element = list.removeLast();
    }

    @Test
    public void removeLast_severalElements_shouldRemoveElementsCorrectly() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);

        int element = list.removeLast();

        int expectedElement = 10;
        int expectedSize = 2;
        Assert.assertEquals(expectedElement, element);
        Assert.assertEquals(expectedSize, list.size());

        List<Integer> items = new ArrayList<>();
        for (Integer integer : list) {
            items.add(integer);
        }

        int[] expectedArray = new int[]{8, 9};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }


    @Test
    public void forEach_emptyList_shouldEnumerateElementsCorrectly() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();

        List<Integer> items = new ArrayList<>();
        list.forEach(items::add);

        int[] expectedArray = new int[]{};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }


    @Test
    public void forEach_singleElement_shouldEnumerateElementsCorrectly() {
        Ex06_DoublyLinkedList<Integer> list = new Ex06_DoublyLinkedList<>();
        list.addLast(5);

        List<Integer> items = new ArrayList<>();
        for (Integer integer : list) {
            items.add(integer);
        }

        int[] expectedArray = new int[]{5};
        int[] array = items.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void forEach_multipleElements_shouldEnumerateElementsCorrectly() {
        Ex06_DoublyLinkedList<String> list = new Ex06_DoublyLinkedList<>();
        list.addLast("Five");
        list.addLast("Six");
        list.addLast("Seven");

        String[] expectedArray = new String[]{"Five", "Six", "Seven"};
        Object[] array = list.toArray();
        Assert.assertArrayEquals(expectedArray, array);
    }


    @Test
    public void iterable_foreach_multipleElements() {
        Ex06_DoublyLinkedList<String> list = new Ex06_DoublyLinkedList<>();

        list.addLast("Five");
        list.addLast("Six");
        list.addLast("Seven");

        String[] expectedArray = new String[]{"Five", "Six", "Seven"};
        String[] array = new String[expectedArray.length];
        int index = 0;
        for (String s : expectedArray) {
            array[index++] = s;
        }

        Assert.assertArrayEquals(expectedArray, array);
    }

    @Test
    public void iterable_nonGeneric_multipleElements() {
        Ex06_DoublyLinkedList<Object> list = new Ex06_DoublyLinkedList<>();

        list.addLast("Five");
        list.addLast(6);
        list.addLast(7.77);

        Object[] expectedArray = new Object[]{"Five", 6, 7.77};
        Object[] array = new Object[expectedArray.length];
        int index = 0;
        for (Object o : expectedArray) {
            array[index++] = o;
        }

        Assert.assertArrayEquals(expectedArray, array);
    }


    @Test
    public void toArray_emptyList_shouldReturnEmptyArray() {
        Ex06_DoublyLinkedList<String> list = new Ex06_DoublyLinkedList<>();

        Object[] array = list.toArray();
        String[] expectedArray = new String[0];

        Assert.assertArrayEquals(expectedArray, array);
    }


    @Test
    public void toArray_nonEmptyList_shouldReturnArray() {
        Ex06_DoublyLinkedList<String> list = new Ex06_DoublyLinkedList<>();

        list.addLast("Five");
        list.addLast("Six");
        list.addLast("Seven");

        Object[] array = list.toArray();
        String[] expectedArray = new String[]{"Five", "Six", "Seven"};

        Assert.assertArrayEquals(expectedArray, array);
    }
}
