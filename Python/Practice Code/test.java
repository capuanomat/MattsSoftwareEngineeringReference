import java.util.Arrays;

public class test {
    public static void main (String[] args) {
        /*
        int[] x = {1, 2, 3};
        int[] y = {1, 2, 3};
        System.out.println(x == y);
        System.out.println(x.equals(y));
        System.out.println(Arrays.equals(x, y));
        int x2 = 2;
        int y2 = 2;

        test2 var = new test2();
        System.out.println(var.anum);
        test2 var2 = new test2();
        System.out.println(var2.anum);
        var2.anum++;
        System.out.println(var2.anum);
        System.out.println(var.anum);
        var.ameth();
        test2.ameth();

        String letter = "a";
        letter = letter + 1;
        System.out.println(letter);
        String str = new String("This is a test");
        System.out.println(str.length());
        System.out.println(str.charAt(1));
        */
        meth(1, 2, 3, 4, 5, 6, 7);
        vaTest(1, 2, 3);
    }

    public static void meth(int a, int b, int c, int...d) {
        System.out.printf("First three: %s, %s, %s", a, b, c);
        System.out.println();
        for (int that : d) {
            System.out.println(that);
        }
    }

    static void vaTest(int ... no) {
        System.out.print("Contents: ");
        for(int n : no)
            System.out.print(n + " ");
        System.out.println();
   }
}
