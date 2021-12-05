// Time Complexity : O(2^n * n)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    List<List<String> > result;
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()] [s.length()];
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int index, List<String> path) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            String curr = s.substring(index, i + 1);
            
            if (s.charAt(index) == s.charAt(i) && (i - index <= 1 || dp[index + 1][i - 1])) {
            
                dp [index][i] = true;
                path.add(curr);
                
                helper(s, i + 1, path);
                
                path.remove(path.size() - 1);
            }
        }
    }
}
    
   