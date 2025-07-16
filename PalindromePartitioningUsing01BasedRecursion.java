// Time Complexity: O(2^n * n) where n is the length of the string
// - There are 2^n possible substring partitioning paths
// - Each valid path performs palindrome checks on substrings of length up to n

// Space Complexity: O(n) for recursion stack and current path list

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This version uses backtracking to find all valid palindrome partitions of a string.
// We use two indices: `pivot` to mark the start of the current substring, and `i` to iterate forward.
// For every `i`, we can either skip (no choose) or select the substring from pivot to i (choose).
// If we choose, and the substring is a palindrome, we add it to the path and update pivot and size.
// The base case is triggered when `i` reaches the end of the string. If the total size of added substrings equals the original string length, we add the path to the result.
// We use backtracking to remove the last added substring after recursion.
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s,0,0,0, new ArrayList<String>());
        return result;
    }

    private void helper(String s, int pivot, int i, int size, ArrayList<String> path) {

        //BC
        if(i == s.length()){
            if(size == s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        //no choose
        helper(s, pivot, i+1, size, path);
        //choose
        String sub = s.substring(pivot,i+1);
        if(isPalindrome(sub)){
            path.add(sub);
            helper(s, i+1, i+1, size+sub.length(), path);
            path.removeLast();
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