//PROBLEM: 1439  Find the Kth Smallest Sum of a Matrix With Sorted Rows

import java.utils.*;

// Uses modified BFS logic and comparator
public class Solution {
    private class Data {
        int[] col;
        int sum;
        Data(int[] col, int sum) {
            this.col = col;
            this.sum = sum;
        }
        
        @Override
        public boolean equals(Object o) {
            if(o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Data that = (Data) o;
            return Arrays.equals(this.col, that.col) && this.sum == that.sum;
        }
        
        @Override
        public int hashCode() {
            int res = 0;
            for(int c : this.col) {
                res += c;
            }
            
            res +=sum;
            return sum;
        }
    }
    public int kthSmallest(int[][] mat, int k) {
        if(mat == null || mat.length == 0 ) {
            return 0;
        }
        
        PriorityQueue<Data> queue = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        HashSet<Data> visited = new HashSet<>();
          
        int[] track = new int[mat.length];
        
        int sumSoFar = 0;
        for(int i = 0; i < mat.length; i++) {
            sumSoFar += mat[i][track[i]];
        }
        Data first = new Data(track, sumSoFar);
        queue.add(first);
        while(k > 0 && !queue.isEmpty()) {
            Data current = queue.poll();
            visited.add(current);
            sumSoFar = current.sum;
            k--;
           System.out.println("it   :" + sumSoFar);
            for(int i = 0; i < mat.length; i++) {
                if(current.col[i] + 1 < mat[0].length) {
                    int curmin = sumSoFar - mat[i][current.col[i]] + mat[i][current.col[i] + 1];
                    int[] copy = Arrays.copyOf(current.col, mat.length);
                   System.out.println(curmin);
                    copy[i] = copy[i] + 1;
                    Data newdata = new Data(copy, curmin);
                    if(!visited.contains(newdata)) {
                        visited.add(newdata);
                        queue.add(newdata);
                    }
                }
            }
        }
        
        
        return sumSoFar;
    }
}

class FindKElementsSmallestSum {
    
}