/**
 * Created by Matthieu J. Capuano on 21/05/2021.
 */
/**
  * REFERENCE: https://www.geeksforgeeks.org/multithreading-in-java/
  *
  * "Multithreading is a Java feature that allows concurrent execution of two or more parts
  * of a program:
  * - This allows maximum utilization of CPU
  * - Each part of such a program is called a "thread"
  * - Threads are light-weight processes within a process
  *
  * You can create threads with two mechanisms:
  * 1. Extending the Thread class
  * 2. Implementing the Runnable Interface
  *
  * Important points:
  * 1. If we extend the Thread class, our class cannot extend any other class (since Java
  *    doesn't support multiple inheritance). But if we implement the Runnable class, we
  *    can still extend other base classes.
  * 2. "We can achieve basic functionality of a thread by extending Thread class because
  *     it provides some inbuilt methods like yield(), interrupt(), etc. that are not
  *     available in Runnable interface.
  *
  * You can find my implementation of method 2 in MultiThreadingDemo2.
 */


/**
 * METHOD 1: Extending the Thread class
 *
 * NOTE: Uncomment the class below and comment the others if wanting to demo it.
 */
class MultiThreadingDemo extends Thread {

    private String someString;

    public MultiThreadingDemo(String someString) {
        this.someString = someString;
    }

    @Override
    public void run() {
        try {
            // Displaying the Thread that is running
            System.out.println(
                "Method 1: Thread " + Thread.currentThread().getId() + " is running.");
            for (int i = 0; i < 100; i++) {
                System.out.print(this.someString + " ");
            }
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exceptionis caught");
        }
    }
}
