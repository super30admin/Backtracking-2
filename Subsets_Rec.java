// Time Complexity : O(n * (2^n)) --> where n is size of input array
// Space Complexity : O(n * (2^n))
// Did this code successfully run on Leetcode (78): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// normal recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        // edge case
        if (nums == null || nums.length == 0) return result;
        
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(int[] nums, List<Integer> temp, int index) {
        // base
        if (index == nums.length) {
            result.add(temp);
            return;
        }
        
        // logic 
        // don't choose
        helper(nums, new ArrayList<>(temp), index+1);
            
        // choose
        temp.add(nums[index]);
        helper(nums, new ArrayList<>(temp), index+1);
    }
}