/*
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different
 * 
 * Example1: 
 * 
 * Input: s = "racecar", t = "carrace"
 * Output: true
 * 
 * Example2:
 * 
 * Input: s = "jar", t = "jam"
 * Output: false
 * 
 * Constraints:
 * s and t consist of lowercase English letters.
 */


/*
 * Solution1: Sorting
 * 
 * Time complexity: O(nlogn + mlogm)
 * Space complexity: O(1) or O(n+m) depeneding on sorting
 */

 public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
}

/*
 * Solution2: HashMap
 * 
 * Time complexity: O(n+m)
 * Space complexity: O(1)
 */

 public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}

/*
 * Solution2: HashTable using array
 * 
 * Time complexity: O(n+m)
 * Space complexity: O(1)
 */

 public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}


