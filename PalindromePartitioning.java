// Time Complexity : O(n * 2^n), n = len of string, for each char if cut or not makes 2^n partitions and each partion is checked if palindrome or not in O(n)
// Space Complexity : O(n), recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use backtracking to explore all possible partitions starting from index 0.
//   - At each step, try all substrings from pivot to current index.
//   - If the substring is a palindrome, recursively call helper for the rest of the string.
//   - Use a helper method to check if a substring is a palindrome.
//   - Backtrack after each recursive call to explore other partitions.

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path) {
        if(pivot == s.length()) {
            //we would be having valid pandromic partition
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot, i+1);
            if(isPalindrome(subStr)) {
                //action
                path.add(subStr);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solver = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> partitions = solver.partition(s);

        System.out.println("Palindrome partitions of \"" + s + "\":");
        for (List<String> part : partitions) {
            System.out.println(part);
        }
    }
}
