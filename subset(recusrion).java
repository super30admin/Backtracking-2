// Time Complexity :O(n*2^n)
// Space Complexity :O(2^n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0)return result;
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    private void helper(int[] nums, List<Integer> temp, int start){
        //base
        if(start == nums.length){
            result.add(temp);
            return;
        }
        //logic
        //not choose
        helper(nums, new ArrayList<>(temp), start + 1);
        
        //choose
        temp.add(nums[start]);
        helper(nums, new ArrayList<>(temp), start + 1);
        
    }
}