// Subsets (https://leetcode.com/problems/subsets/)

// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, there are 2 cases choosing and not choosing. In not choosing case, increase the index by 1 and in choosing case add 
 * element to the path and increase index by 1 and also remove the element lastly added to backtract in stack. When index is
 * equal to length of nums add path to the result. Finally, return result. 
 */
/* 0-1 backtracking recursion */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path, result);
        return result;
    }
    private void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> result){
        //base
        if(idx == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //0
        helper(nums, idx+1, path, result);
        //1
        path.add(nums[idx]);
        helper(nums, idx+1, path, result);
        path.remove(path.size()-1);
    }
}

//for-loop based recursion
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path, result);
        return result;
    }
    private void helper(int[] nums, int pivot, List<Integer> path, List<List<Integer>> result){
        //base
        result.add(new ArrayList<>(path));
        for(int i = pivot; i<nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
}