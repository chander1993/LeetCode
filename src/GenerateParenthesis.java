
//PROBLEM: 22

import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(final int n) {
        if (n == 0) {
            Collections.emptyList();
        }
        combination(n, "", 0, 0);
        return result;
    }

    // this algorithm wil take O(2^2n * n)
    // this can be optimized by keeping track of openning and closing brackets
    // break the tree if the that path is not leading to a valid
    // public void combination(int n, String comb) {
    // if(n == 0) {
    // if(isValid(comb)) {
    // result.add(comb);
    // }

    // return;
    // }

    // combination(n-1, comb + "(");
    // combination(n-1, comb + ")");
    // }

    // public boolean isValid(String input) {
    // ArrayDeque<Character> stack = new ArrayDeque<>();

    // for(int i = 0; i < input.length(); i++) {
    // char cur = input.charAt(i);

    // if(cur == '(') {
    // stack.push(cur);
    // } else {
    // if(stack.isEmpty()) {
    // return false;
    // } else {
    // stack.poll();
    // }

    // }
    // }

    // return stack.isEmpty();
    // }

    // number of open brackets cannot be more than half for a valid parenthesis.
    // number of closing brackets can always be less than or equal to open brackets.
    // imporves the algorithm greatly.
    public void combination(final int n, final String comb, final int open, final int close) {
        if(comb.length() == (n*2)) {
            result.add(comb);
            return;
        }
        
        if(n > open) {
            combination(n, comb + "(", open + 1, close);
        }
        
        if(close < open) {
            combination(n, comb + ")", open, close + 1);
        }
    }
}

public class GenerateParenthesis {

}