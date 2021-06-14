import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

    private static SomeClass someClass = new SomeClass();

    public static void main(String[] args) {
        System.out.println("=== THIS PROGRAM WILL DEADLOCK ===");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new FirstTask());
        executor.execute(new SecondTask());
        executor.shutdown();
    }

    public static class FirstTask implements Runnable {
        @Override
        public void run() {
            someClass.printFirst();
        }
    }

    public static class SecondTask implements Runnable {
        @Override
        public void run() {
            someClass.printSecond();
        }
    }

    private static class SomeClass {
        private static Lock lock1 = new ReentrantLock();
        private static Lock lock2 = new ReentrantLock();

        public void printFirst() {
            lock1.lock();
            try {
                System.out.println("First function - Part 1");
                // Make it sleep so other thread has time to synchronize resource
                Thread.sleep(1000);

                lock2.lock();
                try {
                    System.out.println("First function - Part 2");
                } finally {
                    lock2.unlock();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }

        /**
         * If you re-order the locking in this function so lock1 is locked first,
         * then lock2, you won't get the deadlock.
         */
        public void printSecond() {
            lock2.lock();
            try {
                System.out.println("Second function - Part 1");
                // Make it sleep so other thread has time to synchronize resource
                Thread.sleep(1000);

                lock1.lock();
                try {
                    System.out.println("Second function - Part 2");
                } finally {
                    lock1.unlock();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock2.unlock();
            }
        }
    }
}
