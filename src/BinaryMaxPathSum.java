// PROBLEM:124 Binary Tree Maximum Path Sum

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Wonderful problem
 // finding the edge cases are tricky.
 // what happens when there is only one element and that is negative.
 // 4 possiblity for each nodes. 
 // 1. the current is the root of the final max path sum
 // 2. left + root.val is the part of max path sum
 // 3. right + root.val is the part of max path sum
 // 4. both point 2 and 3 are less than zero so doesnt contribute to the max path sum.
 // wonderful isnt it ? 
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         maxSum(root);
        return max;
    }
    
    public int maxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = maxSum(root.left);
        int right = maxSum(root.right);

         int sum = left + right + root.val;
        
         if(max < sum) {
            max = sum;
        }
        
        int rsum = left + root.val;
        int lsum = right + root.val;
        
        sum = rsum > lsum ? rsum : lsum;
        
        return sum > 0 ? sum : 0;
    }
}
public class BinaryMaxPathSum {

}