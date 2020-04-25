//PROBLEM: 78

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tres = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subset(nums, 0);
        return res;
    }
    
    // premutations loops all the elements in the set
    // combination chooses the first element and loops rest of the element. this helps avoid duplicates
    // whereas subset only talks about current element. whether to include in the result set or not
    public void subset(int[] nums, int index) {
        if(index == nums.length) {
            res.add(new ArrayList<>(tres));
            return;
        }
        
        subset(nums, index + 1);
        tres.add(nums[index]);
        subset(nums, index + 1);
        tres.remove(tres.size() - 1);
    }
}