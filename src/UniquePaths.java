// PROBLEM: 62

import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        Map<String, Integer> map = new HashMap<>();
        int sum = uniquePath(0, 0, m, n, map);
        System.out.println(map);
        return sum;
    }
    
    // memorization technique
    public int uniquePath(int i, int j, int m, int n, Map<String, Integer> map) {
        String key = i + ":" + j;
        
        if(map.containsKey(key)) {
            return map.get(key);
        }
        
        if(i == m-1 && j == n-1) {
            map.put(key, 1);
            return 1;
        }
        
        int sum = 0;
        if(i + 1 < m){
            sum = sum + uniquePath(i+1, j, m, n, map);
        }
        
        if(j + 1 < n) {
            sum = sum + uniquePath(i, j+1, m, n, map);
        }
        
        map.put(key, sum);
        return sum;
        
    }
    
}

public class UniquePaths {

}