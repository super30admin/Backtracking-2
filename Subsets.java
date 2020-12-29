// Time Complexity : O(2 ^ N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> temp) {
        
        result.add(new ArrayList<>(temp));
        
        for ( int i = index; i < nums.length; i++ ) {
            temp.add(nums[i]);
            helper(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        } 
    }
}