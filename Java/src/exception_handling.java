/**
 * Created by Matthieu J. Capuano on 10/04/2020
 */

import org.slf4j.helpers.MessageFormatter;

public class exception_handling {

    public void exception_handling() {

    }

    /**
     * Tutorial: https://community.oracle.com/docs/DOC-983543
     */

    /**
     * - Beginners often start with an exception handling pattern of form: try/catch/printStackTrace().
     *      - When they try to get more creative, they usually stumble into exception handling antipatterns.
     * - Here we look at different types of Java exceptions and their inteded uses
     *      - We also cover basic logging concepts, esp. with relations to exception handling
     */

    /** Basic Exception Concepts
     * - There are three general types of throwable classes in Java:
     * - Checked exceptions: Must be declared in the *throws* clause of a method
     *      - They extend *Exception* and are intended to be "in your face" type of exceptions
     *      - They indicate an expected problem that can occur during normal system operation
     *      - E.g. problems communicating with external systems, user input (parameters passed in to your API,
     *             user interface), etc.
     * - Unchecked exceptions: Exceptions that do not need to be declared in a *throws* clause
     *      - They extend *RuntimeException*
     *      - Indicates an unexpected problem that is probably due to a bug in the code
     *      - E.g. *NullPointerException*
     *      - "There are many core exceptions int he JDK that are checked exceptions but really shouldn't be, like
     *         IllegalAccessException, and NoSuchMethodException"
     *      - The correct response for these is usually to do nothing, and let it bubble out of your method and through
     *        the execution stack, which is why it doesn't need to be declared in a *throws* cause
     * - Errors and serious problems that are almost certainly not recoverable
     *      - E.g. OutOfMemoryError, LinkageError, StackOverflowError
     */


    public static void main(String[] args) {
        exception_handling ex_h = new exception_handling();
        ex_h.my_method1();
    }

    private void my_method1() {
        try {
            int x = 1/0;
        } catch (ArithmeticException e) {
            System.out.println("Error caught.");
            String exception_message = "NEW EXCEPTION MESSAGE";
            throw new ArithmeticException(exception_message, e);
        }
        System.out.println("Rest of program.");
    }


    /** Notes from discussion with Sanji
     * - You add a bit of overhead whenever you try/catch an exception, as opposed to just letting the exception happen
     *   For instance, if part of your code can trigger a NullPointerException, then by doing something like the code
     *   below, you're unecessarily catching and rethrowing it, even if you're just adding some logging it's
     *   questionably useful.
     *      - This is particularly true for high-velocity calls where a bit of overhead can add up to a lot
     *      - So it is often better to just let the exception happen, unless you want to handle it in a specific way
     *        OR if you want to throw a different exception.
     *      - For example, in the case we were discussing, the function definition of our library already threw two
     *        different exceptions: IllegalStateException, and IllegalArgumentException, if we let it throw an NPE now,
     *        then our users also have to handle the NPE, which is annoying to them.
     *          - In that case, it is better to just throw an existing error instead.
     *
     ** Notes from discussion with Ranjeet
     * - Actually, Ranjeet says that it's bad to throw NPEs in general because it doesn't really add anything
     *
     * Further research:
     * - https://stackoverflow.com/questions/3322638/is-it-okay-to-throw-nullpointerexception-programmatically
     *   Probably the best answer imo is whiskeysierra's answers to Roman's response
     */
    private void SanjiDiscussion() {
        try{
            //code
        } catch(NullPointerException ex) {
            log.error("Some error message fro logging.");
            throw new NullPointerException(ex);
        }
    }

}