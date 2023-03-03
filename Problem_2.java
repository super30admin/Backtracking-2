// Time Complexity : O(N * 2^N) where N is size of string
// Space Complexity : O(N), size of string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use backtracking here. We initialize our pivot to 0 and start calling helper function recursively. We check if the substring is 
   palindrome, if it is we call our function again with pivot = i + 1. We also add the substring to our path. When we have checked the
   entire string, we add path to our result since it means all elements in path are palindrome. In the end we return the result.
*/

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0)
            return result;
        
        helper(s, 0, new ArrayList<>());

        return result;
    }

    private void helper(String s, int pivot, List<String> path) {
        if(pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = pivot; i < s.length(); ++i) {
            String str = s.substring(pivot, i + 1);
            if(isPalindrome(str)) {
                path.add(str);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}