//
//# Backtracking-2

//## Problem1 
//Subsets (https://leetcode.com/problems/subsets/)
// Time Complexity : O(2 ^ m)
// Space Complexity : O(2 ^ m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

// 0 1 recursion

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path){
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        helper(nums, index+1, path);
        path.add(nums[index]);
        helper(nums, index+1, path);
        path.remove(path.size() - 1);
    }
}

//
//# Backtracking-2

// ## Problem1 
// Subsets (https://leetcode.com/problems/subsets/)
// Time Complexity : O(2 ^ m)
// Space Complexity : O(2 ^ m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

// for loop based recursion

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path){
        result.add(new ArrayList<>(path));

        for(int i=pivot; i<nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size() - 1);
        }
    
    }
}

//
//# Backtracking-2

// ## Problem1 
// Subsets (https://leetcode.com/problems/subsets/)
// Time Complexity : O(2 ^ m)
// Space Complexity : O(2 ^ m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++){
            int size = result.size();
            for(int j=0; j<size; j++){
                List<Integer> li = new ArrayList<>(result.get(j));
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;

    }
}
// ## Problem2

// Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

class Solution {
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

        for(int i=pivot; i<s.length(); i++){
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s, i+1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}