/**
 * 
 * Time Complexity : 
 * Space Complexity : 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this :
 * 
 *
 
 */
class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return result;
        
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(int [] nums, List<Integer> temp, int index){
        
        //base
        if(index == nums.length) {
            result.add(temp);
            return;
        }

        
        //logic
        
        //dont choose
        helper(nums, new ArrayList<>(temp), index + 1);
        
        //choose
        temp.add(nums[index]);
        helper(nums, new ArrayList<>(temp), index + 1);
        
    }
}