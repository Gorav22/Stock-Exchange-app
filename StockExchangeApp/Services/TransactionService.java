package StockExchangeApp.Services;

import StockExchangeApp.DataStructures.SimpleQueue;
import StockExchangeApp.Models.Transaction;

public class TransactionService {
    private SimpleQueue<Transaction> transactions = new SimpleQueue<>();

    public void recordTransaction(Transaction transaction) {
        if (transaction != null) {
            transactions.enqueue(transaction);
        } else {
            System.out.println("Cannot record a null transaction.");
        }
    }

    public void showTransactionHistory() {
        System.out.println("\n=== Transaction History ===");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        SimpleQueue<Transaction> tempQueue = new SimpleQueue<>();

        while (!transactions.isEmpty()) {
            Transaction tx = transactions.dequeue();
            if (tx != null) {
                tx.display();
            }
            tempQueue.enqueue(tx); 
        }

        while (!tempQueue.isEmpty()) {
            transactions.enqueue(tempQueue.dequeue());
        }
    }
}
