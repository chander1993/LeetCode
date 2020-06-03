// PROBLEM 1029: Two City Scheduling

import java.util.*;

// interesting problem with dual sorting technique
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // comparator computes the difference between [1] and [0]. 
        // sort the 2 columns based on the difference
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        
        int sum  = 0;
        int high = costs.length -1;
        int low = 0;
        while(low < high) {
            sum = sum + costs[low][1] + costs[high][0];
            low++;
            high--;
        }
        
        if(low == high) {
            int i = 1;
            if(costs[low][0] < costs[low][1]) {
                i = 0;
            }
            sum = sum + costs[low][i];
        }
        
        for(int i = 0; i < costs.length; i++) {
            System.out.println(costs[i][0] + " " + costs[i][1]);
        }

        return sum;
    }
}

public class TwoCitySchedulingDualSort {
    
}