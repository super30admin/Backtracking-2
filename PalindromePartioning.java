import java.util.ArrayList;
import java.util.List;

// Time Complexity :O(n2^n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach

public class PalindromePartioning {

    class Solution {
        public List<List<String>> partition(String s) {

            List<List<String>> res = new ArrayList<>();
            if(s.length() == 0) return res;

            helper(res, new ArrayList<>(), s, 0);

            return res;

        }

        private void helper(List<List<String>> res,List<String> cur,String s,int lo ){
            //base case
            if(lo == s.length()) {
                res.add(new ArrayList(cur));
                return;
            }

            int n = s.length();
            for (int hi = lo; hi < n; hi++) {
                if(isPallindrome(s, lo, hi)){
                    cur.add(s.substring(lo, hi+1));//add substring
                    helper(res, cur, s, hi+1);
                    cur.remove(cur.size()-1); //backtrack and remove last substring
                }

            }
        }

        //helper method to determine if string is palindrome
        private boolean isPallindrome(String s, int lo, int hi){
            while(lo <= hi){
                if(s.charAt(lo) != s.charAt(hi)) return false;
                lo++;
                hi--;
            }
            return true;
        }
    }

}
