// PROBLEM: 322

public class Solution {

    // Such a beuaitful concept.
    // top down approach
    // steps to arrive at a problem
    // 1. think what is the answer when the amount is 0, 1, 2, etc. ( these are subproblems)
    // 2. try to solve the problem for these sub problems.
    // 3. the idea is that dp[0] = 0. dp[amount] = number of coins required. 0 coins required for amount 0.
    // 4. try to find the answer for dp[1]. loop through the coins, if the you have '1' in coins array then dp[1 -1] + 1 
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1] ;
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= amount && coins[j] <= i)
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
    
}
class CoinChangeDynamicProgramming {

}