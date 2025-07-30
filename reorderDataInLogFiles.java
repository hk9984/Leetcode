package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 
 * You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

- Letter-logs: All words (except the identifier) consist of lowercase English letters.
- Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

1. The letter-logs come before all digit-logs.
2. The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
3. The digit-logs maintain their relative ordering.

Return the final order of the logs.

Example1: 
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

Example2: 
Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]


 */

public class reorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {

        List<String> digitLogs = new ArrayList<>();

        List<String> resultLogs = new ArrayList<>();

        /*
         * First just separate the digit logs and letter logs. Put the digit logs in the same order 
         * they are encountered in a separate list "digitLogs".
         * And put the letter logs in the final result log
         */

        for(String log : logs) {
            String[] logSeparated = log.split(" ");
            char digitOrLetter = logSeparated[1].charAt(0);

            if(Character.isDigit(digitOrLetter))
                digitLogs.add(log);
            else
                resultLogs.add(log);
        }

        /*
         * 
         * Sort the result logs only containing the letter logs
         */

        Collections.sort(resultLogs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int space1 = s1.indexOf(" ");
                int space2 = s2.indexOf(" ");

                String letterLog1 = s1.substring(space1+1, s1.length());
                String letterLog2 = s2.substring(space2+1, s2.length());

                /*
                 * First compare without the identifier and just the logs
                 */

                int compareVal = letterLog1.compareTo(letterLog2);

                /*
                 * If the log value are the same, then just compare the whole string and
                 * it will automatically sort on the basis of the "identifier" string
                 * as it is the starting string
                 */
                if(compareVal == 0)
                    compareVal = s1.compareTo(s2);
                return compareVal;
                
            }
        });

        /*
         * After sorting the letter logs, simply add the digit logs in the end
         */

        for(String digitLog : digitLogs)
            resultLogs.add(digitLog);

        return resultLogs.toArray(new String[logs.length]);
        
    }

    /*
     * Complexity analysis
     * 
     * 
Let N be the number of logs in the list and
M be the maximum length of a single log.

* Time Complexity: O(M⋅N⋅logN)

        First of all, the time complexity of the Arrays.sort() is O(N⋅logN), as stated in the API specification, which is to say that the compare() function would be invoked O(N⋅logN) times.

For each invocation of the compare() function, it could take up to O(M) time, since we compare the contents of the logs.

Therefore, the overall time complexity of the algorithm is O(M⋅N⋅logN).

* Space Complexity: O(M⋅logN)

For each invocation of the compare() function, we would need up to O(M) space to hold the parsed logs.

In addition, since the implementation of Arrays.sort() is based on quicksort algorithm whose space complexity is O(logn), assuming that the space for each element is O(1)).
Since each log could be of O(M) space, we would need O(M⋅logN) space to hold the intermediate values for sorting.

In total, the overall space complexity of the algorithm is O(M+M⋅logN)=O(M⋅logN).


     */


    
}
