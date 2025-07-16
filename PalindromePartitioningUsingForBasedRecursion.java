// Time Complexity: O(2^n * n) where n is the length of the string
// - There are 2^n possible partitioning decisions in the worst case
// - Each substring check for palindrome takes up to O(n) time

// Space Complexity: O(n) for recursion stack and path list

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This solution uses backtracking.
// At each recursion level, we iterate over all substrings starting from the current pivot.
// For every substring from pivot to i, if it is a palindrome, we add it to the current path.
// We then recurse with the next starting index (i + 1).
// When the pivot reaches the end of the string, we’ve found a valid partition and add it to the result.
// After the recursive call, we backtrack by removing the last added substring.
// The isPalindrome helper function checks whether a given string is a palindrome using two pointers.
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<String>());
        return result;
    }

    private void helper(String s, int pivot, ArrayList<String> path) {

        //BC
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            //Substring between pivot and i
            String sub = s.substring(pivot, i+1);
            //if the substring is palindrome -> then only add it to the path
            if(isPalindrome(sub)){
                //add to path
                path.add(sub);
                //recurse
                helper(s,i+1,path);
                //BT
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String sub) {
        int left = 0;
        int right = sub.length()-1;

        while(left< right){
            if(sub.charAt(left) != sub.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}