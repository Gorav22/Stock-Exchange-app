package StockExchangeApp.DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueue<T>  {
    private Queue<T> queue = new LinkedList<>();

    public void enqueue(T item) { queue.add(item); }
    public T dequeue() { return queue.poll(); }
    public boolean isEmpty() { return queue.isEmpty(); }
    public int size() { return queue.size(); }
}
