/**
 * Created by Matthieu J.B Capuano on 10/20/2017.
 */
public class static_vars_counter_child extends static_vars_counter {

    public static_vars_counter_child() {
        this(999);
        callOneArg(2);
        System.out.println(">> Static vars child no-arg constructor called.");
    }

    public static_vars_counter_child(int i) {
        System.out.println(">> Static vars child one arg constructor called with: " + i);
    }

    public void doSomething() {
        System.out.println("static_var_counter_child doSomething() was called");
    }

    public void method1() {
        System.out.println("METHOD1 CALLED!!");
    }
}
