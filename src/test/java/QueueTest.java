import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Integer> queue = new Queue<>();

    @Test
    public void enqueue_whenOneItem() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    public void enqueue_whenSomeItem() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());
        assertEquals(1, queue.innerStorage.get(0));
        assertEquals(2, queue.innerStorage.get(1));
        assertEquals(3, queue.innerStorage.get(2));
    }

    @Test
    public void dequeue_whenEmpty() {
        assertNull(queue.dequeue());
    }

    @Test
    public void dequeue_whenOneItem() {
        queue.enqueue(1);
        Integer item = queue.dequeue();

        assertEquals(item, 1);
        assertEquals(0, queue.size());
    }

    @Test
    public void dequeue_whenSomeItem() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.dequeue(), 3);
        assertEquals(0, queue.size());
    }

    @Test
    public void rotate_whenOneRotateCount() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.rotate(1);

        assertEquals(queue.innerStorage.get(0), 2);
        assertEquals(queue.innerStorage.get(1), 3);
        assertEquals(queue.innerStorage.get(2), 4);
        assertEquals(queue.innerStorage.get(3), 5);
        assertEquals(queue.innerStorage.get(4), 1);
        assertEquals(5, queue.size());
    }

    @Test
    public void rotate_whenSomeRotateCount() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.rotate(3);

        assertEquals(queue.innerStorage.get(0), 4);
        assertEquals(queue.innerStorage.get(1), 5);
        assertEquals(queue.innerStorage.get(2), 1);
        assertEquals(queue.innerStorage.get(3), 2);
        assertEquals(queue.innerStorage.get(4), 3);
        assertEquals(5, queue.size());
    }

    @Test
    public void rotate_whenRotateCountMoreSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.rotate(11);

        assertEquals(queue.innerStorage.get(0), 2);
        assertEquals(queue.innerStorage.get(1), 3);
        assertEquals(queue.innerStorage.get(2), 4);
        assertEquals(queue.innerStorage.get(3), 5);
        assertEquals(queue.innerStorage.get(4), 1);
        assertEquals(5, queue.size());
    }

    @Test
    public void rotate_whenNegativeRotateCount() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertThrows(IllegalArgumentException.class, () -> queue.rotate(-1));
        assertEquals(queue.innerStorage.get(0), 1);
        assertEquals(queue.innerStorage.get(1), 2);
        assertEquals(queue.innerStorage.get(2), 3);
        assertEquals(queue.innerStorage.get(3), 4);
        assertEquals(queue.innerStorage.get(4), 5);
    }
}