// Time Complexity : O(n * (2^n)) --> where n is size of input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (78): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// backtracking
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        
        // edge case
        if (nums == null || nums.length == 0) return result;
        
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> temp, int start) {
        // logic
        result.add(new ArrayList<>(temp));
        
        for (int i = start; i < nums.length; i++) {
            // action
            temp.add(nums[i]);
            
            // recurse
            backtrack(nums, temp, i+1);
            
            // backtrack
            temp.remove(temp.size() - 1);
        }
    }
}