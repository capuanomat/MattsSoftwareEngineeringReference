import java.util.*;

/**
 * Created by Matthieu J.B Capuano on 11/15/2017.
 */
public class practiceProblems {

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
        for(int i=0; i < s.length(); i++){
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


    /* =============================== LINKED LISTS =============================== */

    /**
     * PROBLEM: removeKFromList
     * NOTE: O(n) time, O(1) space
     * DESCRIPTION: Given a singly linked list of integers l and an integer k, remove all elements
     *              from list l that have a value equal to k.
     * EXAMPLES: ...
     * @param l
     * @param k
     * @return
     */
    class ListNode<T> {
        ListNode(T x) {
        value = x;
        }
        T value;
        ListNode<T> next;
    }
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if (l == null) return null;

        ListNode<Integer> prev = null;
        ListNode<Integer> temp = l;
        while (temp != null) {
            if (temp.value.equals(k)) {
                if (prev == null) {
                    l = l.next;
                } else {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        return l;
    }


    /**
     * PROBLEM: isListPalindrome
     * NOTE: O(n) time, O(1) space
     * DESCRIPTION: Given a singly linked list of integers, determine whether or not it's a
     *              palindrome.
     * EXAMPLES: ...
     * @param l
     * @return
     */
    boolean isListPalindrome(ListNode<Integer> l) {
        if (null == l) return true;

        ListNode slow = l, fast = l;
        while ((null != fast) && (null != fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode end = reverse(slow);
        ListNode front = l;
        while (null != end) {
            if (!front.value.equals(end.value)) {
                System.out.println(front.value);
                System.out.println(end.value);
                return false;
            }
            end = end.next;
            front = front.next;
        }
        return true;
    }

    ListNode reverse(ListNode<Integer> slow) {
        ListNode prev = null;
        while (null != slow) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        return prev;
    }

    /**
     * PROBLEM: addTwoHugeNumbers
     * DESCRIPTION: You're given 2 huge integers represented by linked lists. Each linked list
     *              element is a number from 0 to 9999 that represents a number with exactly 4
     *              digits. The represented number might have leading zeros. Your task is to add
     *              up these huge integers and return the result in the same format.
     * @param a
     * @param b
     * @return
     *
     * SOLUTION 1 (My solution)
     */
    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        if (null == a) return b;
        if (null == b) return a;

        ListNode head1 = reverseList(a);
        ListNode head2 = reverseList(b);

        Integer carry = 0;
        ListNode prev = new ListNode(0);
        ListNode toRet = prev;
        while ((null != head1) || (null != head2))  {
            Integer sum, remainder;
            if ((null != head1) && (null != head2)) {
                sum = (Integer) head1.value + (Integer) head2.value + carry;
            } else if (null == head1) {
                sum = (Integer) head2.value + carry;
            } else {
                sum = (Integer) head1.value + carry;
            }

            remainder = Math.floorMod(sum, 10000);
            carry = (sum - remainder) / 10000;

            ListNode temp = new ListNode(remainder);

            prev.next = temp;
            prev = temp;

            if (head1 != null) { head1 = head1.next; }
            if (head2 != null) { head2 = head2.next; }
        }

        if (carry != 0) {
            prev.next = new ListNode(carry);
        }


        toRet = toRet.next;
        return reverseList(toRet);
    }

    ListNode<Integer> reverseList(ListNode head) {
        ListNode prev = null;
        while (null != head) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * PROBLEM: mergeTwoLinkedLists
     * NOTE: O(l1.length + l2.length) time
     * DESCRIPTION: Given two singly linked lists sorted in non-decreasing order, your task is to
     *              merge them. In other words, return a singly linked list, also sorted in
     *              non-decreasing order, that contains the elements from both original lists.
     * @param l1
     * @param l2
     * @return
     *
     * SOLUTION 1:
     */
    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if ((null == l1) && (null == l2)) return null;
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode toRet;
        if (l1.value <= l2.value) {
            toRet = new ListNode(l1.value);
            l1 = l1.next;
        } else {
            toRet = new ListNode(l2.value);
            l2 = l2.next;
        }
        ListNode curr = toRet;

        while ((null != l1) && (null != l2)) {
            if (l1.value <= l2.value) {
                ListNode newN = new ListNode(l1.value);
                curr.next = newN;
                curr = curr.next;
                l1 = l1.next;
            } else {
                ListNode newN = new ListNode(l2.value);
                curr.next = newN;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if (null != l1) {
            curr.next = l1;
        }
        if (null != l2) {
            curr.next = l2;
        }

        return toRet;
    }

    /* SOLUTION 2 (Recursive) */
    ListNode<Integer> mergeTwoLinkedLists2(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.value<l2.value) {
            l1.next = mergeTwoLinkedLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLinkedLists(l1,l2.next);
            return l2;
        }
    }


    /* =============================== HASH TABLES =============================== */

    /**
     * PROBLEM: groupingDishes
     * DESCRIPTION: You have a list of dishes. Each dish is associated with a list of ingredients
     *              used to prepare it. You want to group the dishes by ingredients, so that for
     *              each ingredient you'll be able to find all the dishes that contain it (if there
     *              are at least 2 such dishes).
     *              Return an array where each element is a list with the first element equal to
     *              the name of the ingredient and all of the other elements equal to the names of
     *              dishes that contain this ingredient. The dishes inside each list should be
     *              sorted lexicographically. The result array should be sorted lexicographically
     *              by the names of the ingredients in its elements.
     * @param dishes
     * @return
     * THIS IS AN IMPORTANT EXAMPLE
     */
    String[][] groupingDishes(String[][] dishes) {
        Map<String, ArrayList<String>> map = new TreeMap();

        for (String[] row: dishes) {
            String dish = row[0];
            for (int i = 1; i < row.length; i++) {
                if (!map.containsKey(row[i])) {
                    ArrayList<String> dishList = new ArrayList();
                    dishList.add(dish);
                    map.put(row[i], dishList);
                } else {
                    map.get(row[i]).add(dish);
                }
            }
        }

        for(String[] row : dishes) {
            for(int i = 1; i < row.length; i++) {
                if(map.get(row[i]).size() < 2) {
                    map.remove(row[i]);
                } else {
                    Collections.sort(map.get(row[i]));
                }
            }
        }

        String[][] toReturn = new String[map.size()][];
        int index = 0;

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            entry.getValue().add(0, entry.getKey());
            toReturn[index++] = entry.getValue().toArray(new String[0]);
            // new String[0] above defines the runTime type of the .toArray created to be a String array
        }

        return toReturn;
    }


    /**
     * PROBLEM: areFollowingPatterns
     * DESCRIPTION: Given an array strings, determine whether it follows the sequence given in the
     *              patterns array. In other words, there should be no i and j for which
     *              strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which
     *              strings[i] ≠ strings[j] and patterns[i] = patterns[j].
     * @param strings
     * @param patterns
     * @return
     * SOLUTION 1
     */
    boolean areFollowingPatterns(String[] strings, String[] patterns) {
        Map<String, ArrayList<Integer>> pattMap = new HashMap();
        Map<String, ArrayList<Integer>> strMap = new HashMap();

        for (int i = 0; i < patterns.length; i++) {
            if (!pattMap.containsKey(patterns[i])) {
                ArrayList<Integer> indices = new ArrayList();
                indices.add(i);
                pattMap.put(patterns[i], indices);
            } else {
                pattMap.get(patterns[i]).add(i);
            }

            if (!strMap.containsKey(strings[i])) {
                ArrayList<Integer> indices = new ArrayList();
                indices.add(i);
                strMap.put(strings[i], indices);
            } else {
                strMap.get(strings[i]).add(i);
            }
        }

        boolean match = true;
        if (pattMap.size() != strMap.size()) {
            return false;
        }
        for (int i = 0; i < pattMap.size(); i++) {
            ArrayList<Integer> pattEntry = pattMap.get(patterns[i]);
            ArrayList<Integer> strEntry = strMap.get(strings[i]);
            if (!pattEntry.equals(strEntry)) {
                match = false;
            }
        }
        return match;
    }

    /* SOLUTION 2 */
    boolean areFollowingPatterns2(String[] strings, String[] patterns) {
        for(int i = 0; i < strings.length; i++){
            for(int j = i + 1; j < strings.length; j++){
                if((strings[i].equals(strings[j]) && !patterns[i].equals(patterns[j]))
                        || (!strings[i].equals(strings[j]) && patterns[i].equals(patterns[j]))){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * PROBLEM: containsCloseNums
     * DESCRIPTION: Given an array of integers nums and an integer k, determine whether there are
     *              two distinct indices i and j in the array where nums[i] = nums[j] and the
     *              absolute difference between i and j is less than or equal to k.
     * @param nums
     * @param k
     * @return
     */
    boolean containsCloseNums(int[] nums, int k) {
        if ((null == nums) || (nums.length < 2) || (k < 1)) return false;

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i ++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                if (Math.abs(i - map.get(key)) <= k) return true;
            }
            map.put(key, i);
        }
        return false;
    }


    /* =============================== TREES: BASIC =============================== */

    class Tree<T> {
        Tree(T x) {
            value = x;
        }
        T value;
        Tree<T> left;
        Tree<T> right;
    }

    /**
     * PROBLEM: hasPathWithGivenSum
     * DESCRIPTION: Given a binary tree t and an integer s, determine whether there is a root to
     *              leaf path in t such that the sum of vertex values equals s.
     * @param t
     * @param s
     * @return
     */
    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        if (t == null) {
            return (s == 0) ? true : false;
        }

        return hasSum(t, s, 0);
    }

    boolean hasSum(Tree<Integer> t, int s, int sum) {
        if (t == null) {
            return false;
        }
        sum += t.value;
        if ((t.left == null) && (t.right == null)) {
            return sum == s;
        }

        return (hasSum(t.left, s, sum) || hasSum(t.right, s, sum));
    }

    /**
     * PROBLEM: isTreeSymmetric
     * DESCRIPTION: Given a binary tree t, determine whether it is symmetric around its center,
     *              i.e. each side mirrors the other.
     * @param t
     * @return
     */
    boolean isTreeSymmetric(Tree<Integer> t) {
        if (t == null) { return true; }

        return helper(t.left, t.right);
    }

    boolean helper(Tree<Integer> t1, Tree<Integer> t2) {
        if ((t1 == null) && (t2 == null)) return true;
        if ((t1 == null) || (t2 == null)) return false;
        if (!(t1.value.equals(t2.value))) return false;

        return (helper(t1.left, t2.right) && helper(t1.right, t2.left));
    }

    /**
     * PROBLEM: kthSmallestInBST
     * NOTE: O(1) space
     * DESCRIPTION: ... Given a binary search tree t, find the kth smallest element in it.
     *              Note that kth smallest element means kth element in increasing order.
     *              See examples for better understanding.
     * @param t
     * @param k
     * @return
     * SOLUTION 1: NOT O(1) space
     */
    int kthSmallestInBST(Tree<Integer> t, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(t, list);
        return list.get(k - 1);
    }

    void inorder(Tree<Integer> curr, ArrayList<Integer> list) {
        if (null != curr) {
            inorder(curr.left, list);
            list.add(curr.value);
            inorder(curr.right, list);
        }
    }

    /* Solution 2 */
    int k, toRet;
    int kthSmallestInBST2(Tree<Integer> t, int k) {
        this.k = k - 1;

        inorder(t);
        return toRet;
    }
    void inorder(Tree<Integer> curr) {
        if (null != curr) {
            inorder(curr.left);
            if (0 == k) toRet = curr.value;
            k--;
            inorder(curr.right);
        }
    }


    /**
     * PROBLEM: isSubtree
     * DESCRIPTION: Given two binary trees t1 and t2, determine whether the second tree is a
     *              subtree of the first tree. A subtree for vertex v in a binary tree t is a tree
     *              consisting of v and all its descendants in t. Determine whether or not there
     *              is a vertex v (possibly none) in tree t1 such that a subtree for vertex v
     *              (possibly empty) in t1 equals t2.
     *
     * @param t1
     * @param t2
     * @return
     *
     * SOLUTION 1
     */
    boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
        if (null == t1) return (null == t2);
        if (null == t2) return true;

        return findSame(t1, t2);
    }

    boolean findSame(Tree<Integer> s1, Tree<Integer> s2) {
        if (null != s1) {
            if (s1.value.equals(s2.value)) {
                if (treeComp(s1, s2)) return true;
            }
            return (findSame(s1.left, s2) || findSame(s1.right, s2));
        }
        return false;
    }

    boolean treeComp(Tree<Integer> c1, Tree<Integer> c2) {
        if ((null != c1) && (null != c2)) {
            if (!c1.value.equals(c2.value)) return false;
            return (treeComp(c1.left, c2.left) &&
                    treeComp(c1.right, c2.right));
        } else if ((null == c1) && (null == c2)) {
            return true;
        } else {
            return false;
        }
    }

    /* SOLUTION 2 */
    boolean isSubtree2(Tree<Integer> t1, Tree<Integer> t2) {
        return treeString(t1).contains(treeString(t2));
    }

    String treeString(Tree<Integer> t){
        if(t == null) return "   ";
        return t.value+" "+treeString(t.left)+" "+treeString(t.right);
    }

    /* Solution 3 */
    boolean isSubtree3(Tree<Integer> t1, Tree<Integer> t2) {
        if (t2 == null)
            return true;

        if (t1 == null)
            return false;

        if (areIdentical(t1, t2))
            return true;

        return isSubtree(t1.left, t2)
                || isSubtree(t1.right, t2);
    }

    boolean areIdentical(Tree<Integer> root1, Tree<Integer> root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.value.equals(root2.value)
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }


    /* =============================== DFS & BFS =============================== */

    /**
     * PROBLEM: traverseTree
     * ........
     * .......
     * @param t
     * @return
     */
    int[] traverseTree(Tree<Integer> t) {
        if (t == null) return new int[0];
        Queue<Tree<Integer>> currList = new LinkedList();
        ArrayList<Integer> toReturn = new ArrayList();
        currList.add(t);
        while (!currList.isEmpty()) {
            Tree<Integer> curr = currList.remove();
            if (curr != null) {
                toReturn.add(curr.value);
                currList.add(curr.left);
                currList.add(curr.right);
            }
        }
        int[] toReturn2 = new int[toReturn.size()];
        for (int i = 0; i < toReturn.size(); i++) {
            toReturn2[i] = toReturn.get(i);
        }
        return toReturn2;
    }


}
