// PROBLEM: 62

// DYNAMIC PROGRAMMING
// Steps to get this solution:
// 1. take smaller examples
// 2. try to visualize it in a matrix form.
// 3. evaluate all the conditions in the question.
// 4. based on the conditions come up with a formula
// in this problem, for any particular cell the number of ways to reach is [i-1][j] or [i][j-1].
// this is because robo can only travel down or right
class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }

    
}
public class UniquePathsDynamicProgramming {

}