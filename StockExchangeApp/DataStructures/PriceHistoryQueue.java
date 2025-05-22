package StockExchangeApp.DataStructures;

public class PriceHistoryQueue {
    private final int size;
    private final double[] queue;
    private int front, rear, count;

    public PriceHistoryQueue(int size) {
        this.size = size;
        this.queue = new double[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // Add price
    public void enqueue(double price) {
        rear = (rear + 1) % size;
        queue[rear] = price;
        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size;
        }
    }

    // Display all prices
    public void display() {
        if (count == 0) {
            System.out.println("No price history available.");
            return;
        }
        System.out.println("Price History:");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % size;
            System.out.println("- $" + queue[index]);
        }
    }
}
