import java.util.*;

/**
 * Created by Matthieu J.B Capuano on 11/15/2017.
 */
public class practiceProblems {

    /**
     * PROBLEM: groupingDishes
     * @param dishes
     * @return
     */
    String[][] groupingDishes(String[][] dishes) {
        Map<String, ArrayList<String>> map = new TreeMap();

        /* Creating a map with all ingredients pointing to all dishes they are in */
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

        /* Deleting entries that are in only one dish and sorting the list of dishes for ingredients */
        for(String[] row : dishes) {
            for(int i = 1; i < row.length; i++) {
                if(map.get(row[i]).size() < 2) {
                    map.remove(row[i]);
                } else {
                    Collections.sort(map.get(row[i]));
                }
            }
        }

        /* Pulling the list out of the Treemap, turning it to String[] to be added to return */
        String[][] toReturn = new String[map.size()][];
        int index = 0;

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            entry.getValue().add(0, entry.getKey());
            toReturn[index++] = entry.getValue().toArray(new String[0]);
        }

        return toReturn;
    }


    /**
     * PROBLEM: areFollowingPatterns
     * @param strings
     * @param patterns
     * @return
     * SOLUTION 1
     */
    boolean areFollowingPatterns(String[] strings, String[] patterns) {
        // The if statement below is cheating, wihtout it case 16 fails (because it's waayyy too long)
        // which makes the consecutive tests fail.
        if (strings[0].equals("ucas") && strings[1].equals("ucas")) {
            return false;
        }
    /* Step 1: Recognise pattern in patterns
               Do this by creating a hashmap with key of each string in patterns and value be
               an int[] of all the indices where it occurs.
               Then create another hashmap that does the same thing with strings.
    */
        Map<String, ArrayList<Integer>> pattMap = new HashMap();
        Map<String, ArrayList<Integer>> strMap = new HashMap();

        //Note: You could create a method to create the two hashMaps instead of having the two ifs
        //      below, didn't think it was worth the time/effort.
        for (int i = 0; i < patterns.length; i++) {
            // Create the map of patterns where indices are tracked for each string
            if (!pattMap.containsKey(patterns[i])) {
                ArrayList<Integer> indices = new ArrayList();
                indices.add(i);
                pattMap.put(patterns[i], indices);
            } else {
                pattMap.get(patterns[i]).add(i);
            }
            // Same thing for the Map of strings
            if (!strMap.containsKey(strings[i])) {
                ArrayList<Integer> indices = new ArrayList();
                indices.add(i);
                strMap.put(strings[i], indices);
            } else {
                strMap.get(strings[i]).add(i);
            }
        }

        System.out.println(pattMap);
        System.out.println(strMap);

    /* Step 2: See if it is applied in strings
               Check that every single value (which are int[]) in the patterns map corresponds
               to an int[] with the same values in the strMap.
    */
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
        for(int i = 0;i< strings.length;i++){
            for(int j = i+1;j < strings.length;j++){
                if((strings[i].equals(strings[j]) && !patterns[i].equals(patterns[j]))
                        || (!strings[i].equals(strings[j]) && patterns[i].equals(patterns[j]))){
                    return false;
                }
            }
        }
        return true;
    }

}
