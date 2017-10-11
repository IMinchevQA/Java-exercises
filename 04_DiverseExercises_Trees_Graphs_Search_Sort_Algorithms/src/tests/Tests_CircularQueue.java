package tests;

import models.Ex05_CircularQueue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ivan Minchev on 9/25/2017.
 */
public class Tests_CircularQueue {
    @Test
    public void enqueue_emptyQueue_shouldAddElement() {
        Ex05_CircularQueue<Integer> queue = new Ex05_CircularQueue<>();

        queue.enqueue(1);

        int expectedSize = 1;
        Assert.assertEquals(expectedSize, queue.size());
    }

    @Test
    public void enqueueDeque_shouldWorkCorrectly() {
        Ex05_CircularQueue<String> queue = new Ex05_CircularQueue<>();
        String element = "some value";

        queue.enqueue(element);
        String elementFromQueue = queue.dequeue();

        int expectedSize = 0;
        Assert.assertEquals(expectedSize, queue.size());
        Assert.assertEquals(element, elementFromQueue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dequeue_emptyQueue_throwsException() {
        Ex05_CircularQueue<Integer> queue = new Ex05_CircularQueue<>();
        queue.dequeue();
    }

    @Test
    public void enqueueDequeue100Elements_shouldWorksCorrectly() {
        Ex05_CircularQueue<Integer> queue = new Ex05_CircularQueue<>();
        int numberOfElements = 100;

        for (int i = 0; i < numberOfElements; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < numberOfElements; i++) {
            int expectesSize = numberOfElements - i;

            Assert.assertEquals(expectesSize, queue.size());
            int element = queue.dequeue();
            Assert.assertEquals(element, i);

            expectesSize = numberOfElements - i - 1;
            Assert.assertEquals(expectesSize, queue.size());
        }
    }

    @Test
    public void circularQueue_enqueueDequeueManyChunks_shouldWorkCorrectly() {
        Ex05_CircularQueue<Integer> queue = new Ex05_CircularQueue<>();
        int chunks = 100;

        int value = 1;
        for (int i = 0; i < chunks; i++) {
            Assert.assertEquals(0, queue.size());
            int chunkSize = i + 1;
            for (int counter = 0; counter < chunkSize; counter++) {
                Assert.assertEquals(value - 1, queue.size());
                queue.enqueue(value);
                Assert.assertEquals(value, queue.size());
                value++;
            }

            for (int counter = 0; counter < chunkSize; counter++) {
                value--;
                Assert.assertEquals(value, queue.size());
                queue.dequeue();
                Assert.assertEquals(value - 1, queue.size());
            }

            Assert.assertEquals(0, queue.size());
        }
    }

    @Test
    public void enqueue500Elements_toArray_shouldWorkCorrectly() {
        Object[] array = new Object[500];
        for (int i = 0; i < 500; i++) {
            array[i] = i;
        }

        Ex05_CircularQueue<Object> queue = new Ex05_CircularQueue<>();

        for (int i = 0; i < array.length; i++) {
            queue.enqueue(array[i]);
        }

        Object[] arrayFromQueue = queue.toArray();

        Assert.assertArrayEquals(array, arrayFromQueue);
    }

    @Test
    public void initialCapacity1_enqueueDequeue20Elements_shouldWorkCorrectly() {
        int elementsCount = 20;
        int initialCapacity = 1;

        Ex05_CircularQueue<Integer> queue = new Ex05_CircularQueue<>(initialCapacity);
        for (int i = 0; i < elementsCount; i++) {
            queue.enqueue(i);
        }

        Assert.assertEquals(elementsCount, queue.size());
        for (int i = 0; i < elementsCount; i++) {
            int elementFromQueue = queue.dequeue();
            Assert.assertEquals(i, elementFromQueue);
        }

        Assert.assertEquals(0, queue.size());
    }

}
