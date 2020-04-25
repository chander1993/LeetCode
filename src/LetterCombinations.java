// PROBLEM: 17

import java.util.*;
class Solution {
    // super set to map digits to letters similar to the telephone buttons
    final Map<Character, String> map = new HashMap<>() {
        {
            put('1', "");
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    // result to be returned
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(final String digits) {
        // validating the input
        if (digits == null || digits.length() == 0)
            return Collections.emptyList();

        // start with empty combination and explore all possible combinations.
        // this can be done in iterative manner but the problem is we will never know the number of inner loops that we need.
        // as the digits input grows the nested loop also will grow.
        // so better to do it in recursive.
        combination(digits, "", 0);
        return result;
    }

    public void combination(final String digits, final String combination, int index) {
        if (index == digits.length()) {
            result.add(combination);
            return;
        }

        final char cur = digits.charAt(index);
        final String letters = map.get(cur);
        index = index + 1;

        // this is the inner loop in the iterative solution.
        // as the digits grows the recursion tree grows with the help of this loop
        for(int i = 0; i < letters.length(); i++) {
            combination(digits, combination + letters.charAt(i), index);
        }
    }
}