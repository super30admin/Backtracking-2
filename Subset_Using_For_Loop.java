// 78. Subsets - https://leetcode.com/problems/subsets/
// Time Complexity : Exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path){
        
        //logic
        result.add(new ArrayList<>(path));
        for(int i=index; i<nums.length; i++){
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}