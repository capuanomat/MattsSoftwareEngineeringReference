import java.util.HashSet;
import java.util.Set;

/**
 * Created by Matthieu J.B Capuano on 11/15/2017.
 * Important notes in preparing for interview.
 */
public class Notes {

    public class Node<T> {
        Node left;
        Node right;
        T data;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(T data) {
            this.data = data;
        }
    }
    /*
    ============================ BINARY SEACH ============================
    - Binary search only works on sorted arrays
    - Time Complexity: O(log⁡(n) ) because you’re halving your data input on each pass
        - Not useful if the sorted array changes often “because insertions and deletions are slow”
    - Space Complexity: O(1) because you just need a reference for the lower and upper bound, and current element
    */
    // BINARY SEARCH ON AN ARRAY:
    public Node binarySearchArray(T[] arr, T value) {
        int min = 0;
        int max = arr.length - 1;

        while (min < max) {
            int mid = (min + max) / 2;
            //if (arr[min].compareTo)
        }
    }

    /*
    == Adding a duplicate to a HashMap replaces the old value
    == Adding a duplicate to a HasSet doesn't insert the new value
     */

    /**
     * PROBLEM: containsDuplicates
     * @param a
     * @return
     * SOLUTION 1:
     */
    boolean containsDuplicates(int[] a) {
        if (null == a || a.length == 0) return false;

        Set<Integer> vals = new HashSet<Integer>();
        for (int curr: a) {
            if (vals.contains(curr)) return true;
            vals.add(curr);
        }
        return false;
    }

    // SOLUTION 2:
    boolean containsDuplicates2(int[] a) {
        Set<Integer> s = new HashSet<>();

        for ( int b : a)
            s.add(b);

        return s.size() != a.length;
    }
    // NOTE: The above works because a set doesn't have duplicates
}
