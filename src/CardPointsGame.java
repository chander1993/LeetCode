// PROBLEM: 1423

// Solves using prefix sum technique
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int prefix = 0;
        
        for(int i = 0; i <k; i++) {
            prefix = prefix + cardPoints[i];
        }
        
        int max = prefix;
        int rightsum = 0;
        int leftp = k - 1;
        for(int i = cardPoints.length - 1; i >= cardPoints.length - k; i--) {
            rightsum = rightsum + cardPoints[i];
            prefix = prefix - cardPoints[leftp--] ;
            int newsum = prefix + rightsum;
            if(max < newsum) {
                max = newsum;
            }
        }
        return max;
    }
}

public class CardPointsGame {

}