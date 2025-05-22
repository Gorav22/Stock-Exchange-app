package StockExchangeApp.DataStructures;

import java.util.ArrayList;

public class CustomPriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public CustomPriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(T value) {
        heap.add(value);
        upheapify(heap.size() - 1);
    }

    private void upheapify(int idx) {
        if (idx == 0) return;
        int parent = (idx - 1) / 2;
        if (heap.get(idx).compareTo(heap.get(parent)) < 0) {
            swap(idx, parent);
            upheapify(parent);
        }
    }

    public T remove() {
        if (heap.isEmpty()) return null;
        swap(0, heap.size() - 1);
        T removed = heap.remove(heap.size() - 1);
        downheapify(0);
        return removed;
    }

    private void downheapify(int idx) {
        int left = 2 * idx + 1, right = 2 * idx + 2;
        int smallest = idx;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0)
            smallest = left;
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0)
            smallest = right;

        if (smallest != idx) {
            swap(idx, smallest);
            downheapify(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
