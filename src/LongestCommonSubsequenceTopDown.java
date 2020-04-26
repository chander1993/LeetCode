// PROBLEM: 1143

import java.util.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Map<String, Integer> map = new HashMap<>();
        int res = longestCommonSubsequence(text1, text2, 0, 0, map);
        return res;
    }
    
    // Top down approach with memoization technique
    public int longestCommonSubsequence(String text1, String text2, int i , int j, Map<String, Integer> map) {
        String key = i + ":" + j;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        
        if(i >= text1.length() || j >= text2.length()) {
            map.put(key, 0);
            return 0;
        }
        
        int count = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            count = longestCommonSubsequence(text1, text2, i+1, j+1, map) + 1;
        } else {
            count = Math.max(longestCommonSubsequence(text1, text2, i+1, j, map), longestCommonSubsequence(text1,                 text2, i, j+1, map));
        }
        map.put(key, count);
        return count;
    }
}

public class LongestCommonSubsequenceTopDown {

}