//TC - O(n.2^n) 
//SC - O(N)

/*
The code uses backtracking to generate all possible palindrome partitions of the string starting from a given index (pivot).
At each step, it tries every possible substring from pivot onward and recurses only if the substring is a palindrome.
When the end of the string is reached, the current partition is added to the result, and backtracking removes the last substring to explore other partitions.
*/

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, res, new ArrayList<>(), 0);
        return res;
    }

    private void helper(String s, List<List<String>> res, List<String> temp, int pivot) {
        //base
        if(pivot == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        //logic
        for(int i = pivot;i<s.length();i++) {
            if(isPalindrome(pivot, i, s)) {
                //action
                temp.add(s.substring(pivot, i+1));
                //recurse
                helper(s, res, temp, i+1);
                //backtrack
                temp.remove(temp.size()-1);
            }
            
            //action
            //recurse

            //backtrack
        }
    }

    private boolean isPalindrome(int start, int end, String s) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
