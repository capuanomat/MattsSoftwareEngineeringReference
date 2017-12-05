package CodeFightsInterview;

/**
 * Created by Matthieu J.B Capuano on 11/27/2017.
 */
public class codeFightsArrays {
    /* =============================== ARRAYS =============================== */

    /**
     * PROBLEM: firstDuplicate
     * NOTE: O(n) time, O(1) space
     * DESCRIPTION: Given an array a that contains only numbers in the range from 1 to a.length,
     *              find the first duplicate number for which the second occurrence has the minimal
     *              index. In other words, if there are more than 1 duplicated numbers, return the
     *              number for which the second occurrence has a smaller index than the second
     *              occurrence of the other number does. If there are no such elements, return -1.
     * EXAMPLES: For a = [2, 3, 3, 1, 5, 2], the output should be: firstDuplicate(a) = 3.
     *              - There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a
     *                smaller index than than second occurrence of 2 does, so the answer is 3.
     *           For a = [2, 4, 3, 5, 1], the output should be firstDuplicate(a) = -1.
     * @param a
     * @return
     */
    int firstDuplicate(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int val = Math.abs(a[i]);
            if (a[val-1] < 0) {
                return val;
            }
            a[val - 1] = -a[val - 1];
        }
        return -1;
    }

    /**
     * PROBLEM: firstNotRepeatingCharacter
     * NOTE: Iterate through string once, O(1) space
     * DESCRIPTION: Given a string s, find and return the first instance of a non-repeating character
     *              in it. If there is no such character, return '_'.
     * EXAMPLES: For s = "abacabad", the output should be firstNotRepeatingCharacter(s) = 'c'.
     *           ...
     *
     * @param s
     * @return
     */
    public static final int NUM_OF_CHARS = 26;
    char[] alphabet = new char[NUM_OF_CHARS];
    int[] indices = new int[NUM_OF_CHARS];

    char firstNotRepeatingCharacter(String s) {
        char curr;
        for (int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            alphabet[((int) curr) - 97] += 1;
            if (indices[((int) curr) - 97] == 0) {
                indices[((int) curr) - 97] = i;
            }
        }
        int minIndex = 100001;
        for (int i = 0; i < NUM_OF_CHARS; i++) {
            if ((alphabet[i] == 1) && (indices[i] < minIndex)) {
                minIndex = indices[i];
            }
        }
        return (minIndex != 100001) ? s.charAt(minIndex) : '_';
    }

    /* TOP SOLUTION 1 */
    char firstNotRepeatingCharacter2(String s) {
        char[] c = s.toCharArray();
        for(int i=0; i < s.length(); i++) {
            if(s.indexOf(c[i]) == s.lastIndexOf(c[i]))
                return c[i];
        }
        return '_';
    }

    /* TOP SOLUTION 2 */
    char firstNotRepeatingCharacter3(String s) {
        int[] counter = new int[26];

        for (char c : s.toCharArray()) counter[c - 'a']++;

        for (char c : s.toCharArray()) {
            if (counter[c - 'a'] == 1) return c;
        }

        return '_';
    }

    /**
     * PROBLEM: rotateImage
     * NOTES: O(1) space
     * DESCRIPTION: You are given an n x n 2D matrix that represents an image. Rotate the image by
     *              90 degrees (clockwise).
     * EXAMPLE: ...
     * @param a
     * @return
     */
    int[][] rotateImage(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < (a.length - 1 - i); j++) {
                int temp = a[i][j];
                a[i][j] = a[a.length - j - 1][a.length - i - 1];
                a[a.length - j - 1][a.length - i - 1] = temp;
            }
        }

        for (int i = 0; i < (a.length/2); i++) {
            for (int j = 0; j < a.length; j++) {
                int temp = a[i][j];
                a[i][j] = a[a.length - i - 1][j];
                a[a.length - i - 1][j] = temp;
            }
        }

        return a;
    }
}
