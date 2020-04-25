// PROBLEM : 46

import java.util.*;

 class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tres = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return res;
    }
    
    public void permute(int[] nums, int index) {
        if(tres.size() == nums.length) {
            // a new list to be created and added because tres is a work array and will be modified.
            res.add(new ArrayList<>(tres));
            return;
        }
        
        // premutations loops all the elements in the set
        // combination chooses the first element and loops rest of the element. this helps avoid duplicates
        // whereas subset only talks about current element. whether to include in the result set or not
        for(int i = 0; i < nums.length; i++) {
            if(tres.contains(nums[i])) continue;  // if the digit is already there in the list then continue.
            
            tres.add(nums[i]);
            permute(nums, index + 1);
            // clear the element once the work is over in the tree. 
            tres.remove(tres.size() - 1);
        }
    }
}

public class Permutations {

}