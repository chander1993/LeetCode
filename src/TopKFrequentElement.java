//PROBLEM: 347
//Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> ic = new HashMap<>();
        
        // count the frequence of the object in the array
        for(int i : nums) {
            ic.put(i, ic.getOrDefault(i, 0) + 1);
        }
        
        // min heap base on count/frequency of the objects
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> ic.get(i1) - ic.get(i2));
        
        // building the min heap. while dicarding all more than k elements.
        for(int i : ic.keySet()) {
            queue.offer(i);
            
            // minimum element in the heap is discarded.
            // this helps to keep the heap only with k largest element at any moment
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            res.add(queue.poll());
        }
        
        // reversing it since we used min heap in our logic. the output will be reversed.
        Collections.reverse(res);
        
        return res;
    }
}