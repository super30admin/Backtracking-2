/* 
Time Complexity: O(n^2 * 2^n)
   - For n length string, exponential partitions × (palindrome checks + creating substrings)

Space Complexity: O(n)
   - O(n) recursion depth + O(n) path (excluding the output list which is O(n * 2^n) in size)

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// 1. Backtracking on a pivot index. At each step, try all substrings s[pivot..i].
// 2. If s[pivot..i] is a palindrome, choose it (push to path) and recurse from i+1.
// 3. When pivot reaches n, add a copy of path to result.
// 4. Use a two-pointer isPalindrome check; backtrack (pop) after exploring.


import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path){
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = pivot; i < s.length(); i++){
            String subStr = s.substring(pivot, i + 1);
            if(isPalindrome(subStr)){
                path.add(subStr);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;

        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
