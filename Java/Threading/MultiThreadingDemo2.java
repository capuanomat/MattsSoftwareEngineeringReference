/**
 * METHOD 2: Implementing the Runnable Interface
 *
 * NOTE: Uncomment the class below and comment the others if wanting to demo it.
 */
class MultiThreadingDemo2 implements Runnable {

    private String someString;

    private boolean yield;

    // If this is not null, then we should wait for this thread to complete.
    private Thread otherThread;

    public MultiThreadingDemo2(String someString, boolean yield, Thread otherThread) {
        this.someString = someString;
        this.yield = yield;
        this.otherThread = otherThread;
    }

    public MultiThreadingDemo2(String someString, boolean yield) {
        this(someString, yield, null);
    }

    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println(
                "Method 2: Thread " + Thread.currentThread().getId() + " is running.");

            // Print someString 100 times
            for (int i = 0; i < 100; i++) {
                System.out.print(this.someString + " ");

                if (yield) {
                    Thread.yield();
                    // Thread.sleep(100);
                }
                // If there's another thread we wait for it to complete after 10 prints
                if (otherThread != null && i == 10)
                    otherThread.join();
            }

        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
