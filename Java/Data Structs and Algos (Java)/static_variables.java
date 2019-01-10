/**
 * Created by Matthieu J.B Capuano on 10/20/2017.
 */
import java.util.Comparator;

public class static_variables {
    static int static_int = 1;
    static static_variables t = null;
    static static_variables t2 = null;

    public static void main(String[] args) {
        /*
            All of the examples below highlight the fact that if you have a static variable within a class,
            then changing the value of that variable from any of its instances, or from a method within the
            class will change the value of that variable.
         */

        System.out.println("Printing initial static variable defined in class scope:");
        System.out.println(static_int + "\n");

        System.out.println("Calling static function that prints static var in class scope (without passing it as input)");
        print_static_int(true);

        System.out.println("Calling static function as above but through an instance of the class the static var is defined in");
        t.print_static_int(true);

        System.out.println("Calling static function that sets static var, then printing it through static function and through instance of class");
        set_static_var(111);
        print_static_int(false);
        t.print_static_int(true);

        System.out.println("Calling static function as above but through instance of class");
        t.set_static_var(222);
        print_static_int(false);
        t.print_static_int(true);

        System.out.println("Static variable value " + static_int);
        System.out.println("Static variable first class instance value " + t.static_int);
        System.out.println("Static variable second class instance value " + t2.static_int + "\n");

        t2.set_static_var(333);
        System.out.println("Static variable value " + static_int);
        System.out.println("Static variable first class instance value " + t.static_int);
        System.out.println("Static variable second class instance value " + t2.static_int + "\n");

        System.out.println("Creating instance of static_vars_counter and printing count");
        static_vars_counter f = new static_vars_counter();
        System.out.println(f.count + "\n");

        System.out.println("Creating instance of static_vars_counter but initializing coutner at 2, then printing it");
        static_vars_counter f2 = new static_vars_counter(2);
        System.out.println(f.count);
        System.out.println(f2.count + "\n");

        System.out.println("Creating two instances of static_var_counter_child, one of them having compile time type static_var_counter");
        static_vars_counter_child c = new static_vars_counter_child();

        System.out.println();
        static_vars_counter f3 = new static_vars_counter_child();


        //new static_var_counter_child();
        //System.out.println(static_var_counter.getCount());
    }

    public static void print_static_int(boolean space) {
        System.out.println(space ? static_int + "\n" : static_int);
    }

    public static void set_static_var(int value) {
        t.static_int = value;
    }
}
