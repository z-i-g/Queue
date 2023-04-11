import java.util.*;

public class StackQueue<T> {

    Stack<T> in;
    Stack<T> out;
    public StackQueue()
    {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void enqueue(T item)
    {
        in.push(item);
    }

    public T dequeue()
    {
        int s = in.size();
        for (int i = 0; i < s; i++) {
            out.push(in.pop());
        }
        return out.size() == 0 ? null : out.pop();
    }

    public int size()
    {
        return Math.max(in.size(), out.size());
    }
}