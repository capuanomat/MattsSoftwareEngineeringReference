package CodeFightsInterview;

/**
 * Created by Matthieu J.B Capuano on 11/27/2017.
 */
public class codeFightsStrings {
    /**
     * PROBLEM: You have been given a string s, which is supposed to be a sentence. However,
     *          someone forgot to put spaces between the different words, and for some reason
     *          they capitalized the first letter of every word. Return the sentence after making
     *          the following amendments:
     *          - Put a single space between the words.
     *          - Convert the uppercase letters to lowercase.
     * EXAMPLES: ...
     * @param s
     * @return
     * SOLUTION 1
     */
    String amendTheSentence(String s) {
        char[] arr = s.toCharArray();
        String toRet = "";
        int count = 0;
        for (char c : arr) {
            int ascii = (int) c;
            if (((65 <= ascii) && (ascii <= 90))) {
                toRet += (count == 0) ?
                        ((char) (ascii + 32)) : (" " + (char) (ascii + 32));
            } else {
                toRet += c;
            }
            count++;
        }

        return toRet;
    }

    /** SOLUTION 1a: you can just do toRet.trim() instead of worrying about the extra space at
     *               the start in the event that the first character is caps.
     *               You could improve the solution below even further with elements from
     *               solution 4: using Characters.isUpperCase() and Characters.toLowerCase(c)
     */
    String amendTheSentence1a(String s) {
        String toRet = "";
        for (char c : s.toCharArray()) {
            int ascii = (int) c;
            if (((65 <= ascii) && (ascii <= 90))) {
                toRet += " " + (char) (ascii + 32);
            } else {
                toRet += c;
            }
        }

        return toRet.trim();
    }

    /** SOLUTION 2 **/
    // I think this uses a regular expression to split wherever there's a capital letter and
    // then rejoins by adding a " " and toLowerCase()ing the whole thing
    String amendTheSentence2(String s) {
        String[] split = s.split("(?=[A-Z])");
        return String.join(" ", split).toLowerCase();
    }

    /** SOLUTION 3 **/
    String amendTheSentence3(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(Character.isUpperCase(c)){
                builder.append(" " + Character.toLowerCase(c));
            } else{
                builder.append("" + c);
            }
        }
        return builder.toString().trim();
    }




    /* Brute-Force solution (too slow):
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == x.charAt(0)) {
            int j = 0;
            while ((j < x.length()) && (i + j < s.length())) {
                if ((i + j) < s.length()) {
                    if ((j == x.length() - 1) &&
                        (s.charAt(i + j) == (x.charAt(j)))) {
                        return i;
                    } else if (s.charAt(i + j) == (x.charAt(j))) {
                        j++;
                    } else {
                        j = x.length();
                    }
                }
            }
        }
    }
    return -1;
    */
}
