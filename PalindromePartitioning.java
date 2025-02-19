// Time Complexity : O (n * 2^n)
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    void backtrack(String s, int index, List<String> subRes) {
        // base case - index equals string length
        if(index == s.length()) {
            // add the string to the result
            result.add(new ArrayList<>(subRes));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            // backtrack only if it is a palindrome
            if(isPalindrome(s, index, i)) {
                //add the substring to the list if a palindrome
                subRes.add(s.substring(index, i + 1));
                //backtrack from next index
                backtrack(s, i + 1, subRes);
                // remove last added substring
                subRes.removeLast();
            }
        }
    }
    /**
     * Function to check if a string s is a palindrome
     */
    boolean isPalindrome(String s, int start, int end) {
        int i = start, j = end;
        while(i <= j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
