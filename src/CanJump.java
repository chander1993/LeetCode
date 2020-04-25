// PROBLEM : 55

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] res = new boolean[nums.length];
        res[nums.length-1]  = true;
        for(int i = nums.length-1; i >= 0; i--) {
            
            for(int j=nums[i]; j >= 0; j--) {
                if(i+j < nums.length && res[i+j]) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[0];
    }

}