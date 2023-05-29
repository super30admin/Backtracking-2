## Problem1 
Subsets (https://leetcode.com/problems/subsets/)

// Time Complexity - 0(2^n) where N is the length of the input array nums. This is because for each element in the array, 
//                   we have two choices: either include it in the current subset or exclude it.
// Space Complexity - O(N) because the depth of the recursion is limited by the length of the input array nums.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int index, List<Integer> path) {
        
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);                   // action
            helper(nums, i + 1, path);           // recurse
            path.remove(path.size() - 1);        // backtrack
        }
    }
}

## Problem2

Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

// Time Complexity - 0(n * 2 ^ n) because for each character in the string, we have two choices: either include it in the current partition or not
// Space Complexity - 0(n ^ 2)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(s, new ArrayList<>());
        return result;       
    }
    private void backtrack(String s, List<String> path) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                path.add(s.substring(0, i + 1));
                backtrack(s.substring(i + 1), path);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}