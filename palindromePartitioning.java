// Time Complexity : O(n * 2^n) for loop + exploring each node 
// Space Complexity : O(n * 2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
we use a helper function with list of soFar 

if we reach the end we add the list to the final list

else i = idx+1 and 
from idx to i we get the substring see if its a palindrome
 if yes we add the substring to sofar and we pass this i as idx to helper and continue
*/

class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if (s.length() == 0 || s == null)
            return res;
        helper(s, 0, new LinkedList<String>(), res);
        return res;
    }

    private void helper(String s, int idx, List<String> soFar, List<List<String>> res) {
        // base case
        if (idx == s.length()) {
            res.add(soFar);
            return;
        }

        // recursion
        for (int i = idx + 1; i <= s.length(); i++) {

            if (isPalindrome(s.substring(idx, i))) {
                List<String> temp = new LinkedList<>(soFar);
                temp.add(s.substring(idx, i));
                helper(s, i, temp, res);
            }

        }

    }

    public boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}