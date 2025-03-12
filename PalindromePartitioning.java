//Time Complexity : O(n*2^n)
//Space Complexity : O(n*2^n)
import java.util.*;
class PalindromePartitioning {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return res;
    }
    private void helper(String s, int pivot, List<String> path) {
        //base case
        if(pivot == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot, i+1);
            if(isPalindrome(subStr)) {
                path.add(subStr);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int start = 0; int end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}