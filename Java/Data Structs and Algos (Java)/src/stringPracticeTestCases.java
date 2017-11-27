import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Matthieu J.B Capuano on 11/26/2017.
 */
public class stringPracticeTestCases {
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {

    }

    @Test(timeout = TIMEOUT)
    public void printDupsTests() {
        stringPractice.printDups("fdkjg2");
    }

    @Test(timeout = TIMEOUT)
    public void anagCheckTests() {
        assertTrue(stringPractice.anagCheck("this", "sith"));
    }

    @Test(timeout = TIMEOUT)
    public void firstUniqCharTests() {
        assertEquals(0, stringPractice.firstUniqChar("leetcode"));
        assertEquals(2, stringPractice.firstUniqChar("loveleetcode"));
        System.out.println("HERREEEEEEE: " + stringPractice.firstUniqChar2("leetcode"));
        assertEquals(0, stringPractice.firstUniqChar2("leetcode"));
        assertEquals(2, stringPractice.firstUniqChar2("loveleetcode"));
        assertEquals(1, stringPractice.firstUniqChar3("abcdefghija"));
        assertEquals(0, stringPractice.firstUniqChar3("hello"));
        assertEquals(0, stringPractice.firstUniqChar3("Java"));
        assertEquals(1, stringPractice.firstUniqChar3("simplest"));
    }

    @Test(timeout = TIMEOUT)
    public void reverseStrTests() {
        assertEquals("GMO TSET A SI SIHT", stringPractice.reverseStr4("THIS IS A TEST OMG"));
    }

    @Test(timeout = TIMEOUT)
    public void printDupsWithCountTests() {
        stringPractice.printDupsWithCounts("THISSS ISSSS A POTATO!");
        System.out.println("---- Test Case 2 ----");
        stringPractice.printDupsWithCounts("abbcccddddeeeeeffffffggggggghhhhhhhhiiiiiiiiijjjjjjjjjj");
    }

    @Test(timeout = TIMEOUT)
    public void vowsAndConsTests() {
        System.out.println(stringPractice.vowsAndCons("aeiou123456AEIOUMMMMM"));
        assertEquals("Vowels: 0 Consonants: 15",
                stringPractice.vowsAndCons("mmmmMmmmmMmmmmM"));
        System.out.println(stringPractice.vowsAndCons("mmmmMmmmmMmmmmM"));
        assertEquals("Vowels: 3 Consonants: 9",
                stringPractice.vowsAndCons("thisisokkkkk"));
        System.out.println(stringPractice.vowsAndCons("thisisokkkkk"));
    }
}
