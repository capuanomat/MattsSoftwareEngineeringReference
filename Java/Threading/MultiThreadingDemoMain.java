import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Main class to run example scripts for Multithreading in Threading package
 */
public class MultiThreadingDemoMain {
    public static void main(String[] args) {

        // callSingleMethod1Thread("a");
        // callSingleMethod2Thread("b", true);
        // callSingleMethod2Thread("c", false);

        // testYieldMethod2();

        // testExecutorFixedThreadPool();
        testExecutorCachedThreadPool();
    }

    private static void callSingleMethod1Thread(String s) {
        // This class directly extends Thread, so we can just call .start()
        MultiThreadingDemo threadingDemo1 = new MultiThreadingDemo(s);
        threadingDemo1.start();
    }

    private static void callSingleMethod2Thread(String s, boolean yield) {
        // This class implements Runnable, so we create a thread from it, then call .start()
        MultiThreadingDemo2 threadingDemo2 = new MultiThreadingDemo2(s, yield);
        Thread thread = new Thread(threadingDemo2);
        thread.start();
    }

    private static void testYieldMethod2() {
        MultiThreadingDemo2 task1 = new MultiThreadingDemo2("a", false);
        Thread thread1 = new Thread(task1);

        MultiThreadingDemo2 task2 = new MultiThreadingDemo2("b", false, thread1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }

    private static void testExecutorFixedThreadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new MultiThreadingDemo2("a", false));
        executor.execute(new MultiThreadingDemo2("b", false));
        executor.shutdown();
    }

    private static void testExecutorCachedThreadPool() {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new MultiThreadingDemo2("c", false));
        executor.execute(new MultiThreadingDemo2("d", false));
        executor.shutdown();
    }
}
