package Leetcode.Neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Group Anagrams

Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
Example 2:

Input: strs = ["x"]

Output: [["x"]]
Example 3:

Input: strs = [""]

Output: [[""]]
Constraints:

- 1 <= strs.length <= 1000.
- 0 <= strs[i].length <= 100
- strs[i] is made up of lowercase English letters.

 */

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> pairAnagrams = new HashMap<String, List<String>>();

        for(String s: strs) {
            int[] chCount = new int[26];
            for(char c: s.toCharArray())
                chCount[c - 'a']++;
            String chCountKey = Arrays.toString(chCount);
            
            if(!pairAnagrams.containsKey(chCountKey))
                pairAnagrams.put(chCountKey, new ArrayList<String>());
                
            pairAnagrams.get(chCountKey).add(s);
        }

        return new ArrayList<>(pairAnagrams.values());
    }


    
}
