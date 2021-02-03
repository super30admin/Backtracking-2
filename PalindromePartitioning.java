// Time Complexity : O(n2 2n) (n square * 2 to the power n exponantial) n2 is for isPalindrome & substring
//2 to power n comparisions
// Space Complexity : O(n) where n is the length of the path + O(n) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Used recursion + backtracking
// If the initial string is not isPalindrome, stop the loop for that branch there.


class Solution {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        if(s == null || s.length()== 0) return result;
        helper(s, new ArrayList<String>(), 0);
        return result;
    }

    private void helper(String s, List<String> path, int index) {

        if(index >= s.length()) {
            result.add(new ArrayList(path));
            return;
        }

        for(int i = index; i < s.length(); i++) {

            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                helper(s, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
       while(i < j) {
           if(s.charAt(i) != s.charAt(j)) return false;
           i++;
           j--;
       }
        return true;


    }
}
