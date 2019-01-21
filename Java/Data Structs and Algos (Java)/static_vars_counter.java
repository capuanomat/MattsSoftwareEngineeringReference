/**
 * Created by Matthieu J.B Capuano on 10/20/2017.
 */
public class static_vars_counter {
    static int count = 0;

    public static_vars_counter() {
        System.out.println("> Static vars no-argument constructor was called!");
        //doSomething();
    }

    public static_vars_counter(int i) {
        System.out.println("> Static vars argument constructor was called!");
        count += i;
    }

    public void callOneArg(int i) {
        new static_vars_counter(i);
    }

    public static int getCount() { return count; }

    public void doSomething() {
        System.out.println("static_vars_counter doSomething() was called");
    }

    public void method1() { System.out.println("METHOD1 CALLED!!"); }
}
