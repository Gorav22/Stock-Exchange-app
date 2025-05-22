package StockExchangeApp.DataStructures;

import java.util.Stack;

public class SimpleStack<T> {
    private Stack<T> stack = new Stack<>();

    public void push(T item) { stack.push(item); }
    public T pop() { return stack.pop(); }
    public T peek() { return stack.peek(); }
    public boolean isEmpty() { return stack.isEmpty(); }
}
