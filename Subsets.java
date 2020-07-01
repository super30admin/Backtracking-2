// Time Complexity: O(n*2^n) for both approached
// Space Complexity: O(n x 2^n) for recursion and O(n) for Backtracking
// Successfully ran on leetcode

// Recursive Approach
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        helper(nums,new ArrayList<>(),0);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> temp, int idx) {
        if(idx == nums.length) {
            res.add(temp);
            return;
        }
        // dont choose
        helper(nums,new ArrayList<>(temp),idx+1);
        //choose
        temp.add(nums[idx]);
        helper(nums,new ArrayList<>(temp),idx+1);
    }
}

// Backtracking Solution
// Here we will be using simple backtracking to track the array given add the elements in the list then come back remove that element add another one...i.e. we can simply use backtracking to form all the possible subsets from the given array



class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        backtrack(nums,new ArrayList<>(),0);
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> temp, int start) {
        //logic
        res.add(new ArrayList<>(temp));
        for(int i=0;i<nums.length;i++) {
            // add current element to path - action
            temp.add(nums[i]);
            // recurse
            backtrack(nums,temp,i+1);
            //backtrack
            temp.remove(temp.size()-1);
        }
    }
}