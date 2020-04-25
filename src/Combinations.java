
//PROBLEM: 77
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tres = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, 1);
        return res;
    }
    
    // premutations loops all the elements in the set
    // combination chooses the first element and loops rest of the element. this helps avoid duplicates
    // whereas subset only talks about current element. whether to include in the result set or not
    public void combine(int n, int k, int index) {
        if(tres.size() == k) {
            res.add(new ArrayList<>(tres));
            return;
        }
        
        for(int i = index; i <= n; i++) {
            tres.add(i);
            combine(n, k, i + 1);
            tres.remove(tres.size() - 1);
        }
    }
    
    
}