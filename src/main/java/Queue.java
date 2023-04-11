import java.util.*;

public class Queue<T> {

    List<T> innerStorage;
    public Queue()
    {
        innerStorage = new LinkedList<>();
    }

    public void enqueue(T item)
    {
        innerStorage.add(item);
    }

    public T dequeue()
    {
        return innerStorage.size() == 0 ? null : innerStorage.remove(0);
    }

    public int size()
    {
        return innerStorage.size();
    }

    public void rotate(int itemCount) {
        if (itemCount >= size()) {
            itemCount = itemCount % size();
        }
        if (itemCount < 0)
            throw new IllegalArgumentException();

        for (int i = 0; i < itemCount; i++) {
            innerStorage.add(innerStorage.remove(0));
        }
    }
}