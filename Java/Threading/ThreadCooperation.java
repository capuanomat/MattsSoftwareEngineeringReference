import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ThreadCooperation {

    private static Account account = new Account();

    public static void main(String[] args) {
        System.out.println("Thread 1\t\tThread 2 \t\tBalance");

        // Create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.execute(new HelloTask());
        executor.shutdown();
    }

    public static class DepositTask implements Runnable {
        @Override
        public void run() {
            try {
                // Continuously try to deposit a random amount of money in account
                while (true) {
                    account.deposit((int)(Math.random() * 10) + 1);
                    // Sleep for a second to let the withdraw method proceed
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class WithdrawTask implements Runnable {
        @Override
        public void run() {
            // Continuously try to withdraw from the account
            while (true) {
                account.withdraw((int)(Math.random() * 10) + 1);
            }
        }
    }

    public static class HelloTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    account.hello();
                    Thread.sleep(2000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class Account {
        // Create a new locks
        private static Lock lock = new ReentrantLock();

        // Create a condition
        private static Condition newDeposit = lock.newCondition();

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void hello() {
            lock.lock();
            try {
                System.out.println("I'm here too guys.");
                newDeposit.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void withdraw(int amount) {
            lock.lock(); // Acquire the lock
            try {
                System.out.println("\t\t\tTry to withdraw " + amount + "\t" + getBalance());
                while (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    newDeposit.await();
                }
                balance -= amount;
                System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void deposit(int amount) {
            lock.lock();
            try {
                balance += amount;
                System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());

                // Signal thread waiting on the Condition
                newDeposit.signalAll();
            } finally {
                lock.unlock();
            }
        }

    }

}
